package operation;
import entity.Audios;
import java.sql.*;
import java.util.List;

public class PlaylistOperation {

     static Connection conn;

    static {
        try {
            conn = connection.connectionestablishment.connectionEstablishment();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void displayplaylist(List<Audios> playlistSongs){
        System.out.printf("%25s%25s%25s%25s%25s%25s", "Audio Name", "Artist Name","Album Name","Genre Name","Celebrity Name","Publish Name");
        System.out.println();
        for(int i=0;i<playlistSongs.size();i++){
            if(playlistSongs.get(i).getSong()==null) {
                System.out.printf("%25s%25s%25s%25s%25s%25s", playlistSongs.get(i).getPod().getPodcastName(), "N/A", "N/A", "N/A", playlistSongs.get(i).getPod().getCelebrityName(), playlistSongs.get(i).getPod().getPublishDate());
                System.out.println();
            }
            else{
                System.out.printf("%25s%25s%25s%25s%25s%25s", playlistSongs.get(i).getSong().getSong_name(), playlistSongs.get(i).getSong().getArtist_name(), playlistSongs.get(i).getSong().getAlbum_name(),playlistSongs.get(i).getSong().getSong_genre() , "N/A", "N/A");
                System.out.println();
            }
        }
    }



    }

