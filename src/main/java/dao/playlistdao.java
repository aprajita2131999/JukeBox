package dao;

import connection.connectionestablishment;
import customexceptions.PlayListNotFoundException;
import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class playlistdao {


  songdao songdao=new songdao();
    static Connection conn;

    static {
        try {
            conn = connectionestablishment.connectionEstablishment();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<audio> audioList()throws SQLException{
        //Query to retrieve audioList
        String query="SELECT * FROM audio";
        PreparedStatement ps=conn.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        List<audio> audiolist=new ArrayList();
        while(rs.next()){
            audio audioobj=new audio(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            audiolist.add(audioobj);
        }

        return audiolist;

    }
    public void insertintoPlaylist(int userId,String audioId,String playlistName) throws SQLException,ClassNotFoundException{
         String str="insert into playlist(userId,audioId,playlist_name) values (?,?,?)";
         PreparedStatement ps=conn.prepareStatement(str);
         ps.setInt(1,userId);
         ps.setString(2,audioId);
         ps.setString(3,playlistName);
         int rowsAffected=ps.executeUpdate();
         if(rowsAffected>=1) {
             if (audioId == null) {
                 System.out.println(playlistName + " playList Successfully Created");
             } else
                 System.out.println("Song successfully inserted in a " + playlistName + " playlist");
         }
    }


    public List<Audios> getSongsByPlaylistName(String playlistName)throws SQLException,ClassNotFoundException, PlayListNotFoundException {
        List<audio> audioList = audioList();
        List<song>  songList= songdao.songslist();
        List<podcast> podcastList=podcastdao.podcastlist();
        String str="select * from playlist where playlist_name = ? and audioId is not null";
        PreparedStatement ps=conn.prepareStatement(str);
        ps.setString(1,playlistName);
        ResultSet rs=ps.executeQuery();
        List<Audios> playlist=new ArrayList<>();
        while(rs.next()){
           String audioId= rs.getString(3);
           for(audio a:audioList){
               if(audioId.equalsIgnoreCase(a.getAudio_id())) {
                   if(a.getType()==1) {
                       String songId = a.getSong_id();
                       for (song s : songList) {
                           if (s.getSong_id().equalsIgnoreCase(songId)) {
                               playlist.add(new Audios(s));
                           }
                       }
                   }
                       else{
                           if (a.getType() == 2) {
                                 String podcastId=a.getPodcast_id();
                                 for(podcast p :podcastList){
                                     if(p.getPodcastId().equalsIgnoreCase(podcastId)){
                                         playlist.add(new Audios(p));
                                     }
                                 }
                           }
                       }

               }

           }
        }
        if(playlist.isEmpty()){
            throw new PlayListNotFoundException("Song Not Found");
        }
        else
        return playlist;
    }

    public static void deleteSongFromPlaylist(String audioid) throws SQLException {

        //Delete record from playlist with given audio id
        String str="Delete from playlist where audioId = ? and audioId is NOT NULL";
        PreparedStatement ps=conn.prepareStatement(str);
        ps.setString(1,audioid);
        int rowsAffected=ps.executeUpdate();
        if(rowsAffected>0){
            System.out.println("Song succesfully deleted from playlist");
        }
        else{
            System.out.println("Song deletion failed");
        }
    }
}
