package app;

import audio.audioPlayer;
import customexceptions.PlayListNotFoundException;
import customexceptions.songsNotFoundException;
import dao.playlistdao;
import dao.podcastdao;
import dao.songdao;
import dao.userdao;
import entity.*;
import operation.PlaylistOperation;
import operation.podcastOperation;
import operation.songOperation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        System.out.println("HI!!! Welcome to Jukebox!!!");
        songdao songdao=new songdao();
        podcastdao podcastdaoobj=new podcastdao();
        playlistdao playlistdao=new playlistdao();
        songOperation songOperationobj=new songOperation();
        podcastOperation podcastOperationobj=new podcastOperation();
        BufferedReader bi = new BufferedReader(
                new InputStreamReader(System.in));
        userdao userdaoobj=new userdao();
        System.out.println("1.Login");
        System.out.println("2.SignUp");
        Scanner sc=new Scanner(System.in);
        int mainmenu,songsmenu,podcastmenu,pllimenu,playsongs;

                while (true) {
                    System.out.println("Log in / Sign Up");
                    int no = sc.nextInt();
                    switch (no) {
                        case 1:
                            boolean flag = false;
                            List<user> userList = userdaoobj.getUserList();
                            System.out.println("Enter your userName");
                            String userName = sc.next();
                            System.out.println("Enter your password");
                            String password = sc.next();
                            for (user u : userList) {
                                if (userName.equalsIgnoreCase(u.getUserName()) && password.equalsIgnoreCase(u.getPassword())) {
                                    System.out.println("HII "+userName+" !!");
                                    flag=true;
                                     {
                                         do{
                                             System.out.println("1.Songs");
                                             System.out.println("2.Podcast");
                                             System.out.println("3.Playlist");
                                             System.out.println("4.Log out");
                                             mainmenu = sc.nextInt();
                                             switch (mainmenu) {

                                                 //Case statements
                                                 case 1: {
                                                     do {
                                                         System.out.println("1.Display all song");
                                                         System.out.println("2.Display songs of an artist");
                                                         System.out.println("3.Display songs of an album");
                                                         System.out.println("4.Display songs by Genre");
                                                         System.out.println("5.Go to Home Menu");
                                                         songsmenu = sc.nextInt();
                                                         songOperation songoperation = new songOperation();
                                                         songdao = new songdao();
                                                         switch (songsmenu) {
                                                             // Case
                                                             case 1:
                                                                 //dispaly songs
                                                                 System.out.println("Display all songs");
                                                                 List<song> allsongs = songdao.songslist();
                                                                 songoperation.displaysongs(allsongs);
                                                                 break;

                                                             // Case
                                                             case 2:
                                                                 try {
                                                                     //display songs of particular artist
                                                                     System.out.println("Enter the artist name");
                                                                     String artist_name = sc.next();
                                                                     List<song> allsongsByArtist = songOperationobj.songsListByArtist(artist_name);
                                                                     songoperation.displaysongs(allsongsByArtist);
                                                                 }catch (songsNotFoundException s){
                                                                 }
                                                                 break;

                                                             // Case
                                                             case 3:
                                                                 //display songs of particular Album
                                                                 System.out.println("Enter the album name");
                                                                 String album_name = sc.next();
                                                                 List<song> allsongsByAlbum = songOperationobj.songsListByAlbum(album_name);
                                                                 songoperation.displaysongs(allsongsByAlbum);
                                                                 break;

                                                             case 4: {
                                                                 //display songs of particular Genre
                                                                 System.out.println("Enter the genre name");
                                                                 String genre_name = sc.next();
                                                                 List<song> allsongsByGenre = songOperationobj.songsListByGenre(genre_name);
                                                                 songoperation.displaysongs(allsongsByGenre);
                                                                 break;
                                                             }

                                                             case 5: {
                                                                 System.out.println("Main Menu");
                                                             }


                                                         }
                                                     }
                                                     while (songsmenu != 5);

                                                     break;
                                                 }

                                                 case 2: {
                                                     System.out.println("Podcast");
                                                     do {

                                                         System.out.println("1.Display all Podcast");
                                                         System.out.println("2.Display Podcast of a Celebrity");
                                                         System.out.println("3.Display publish date of podcast");
                                                         System.out.println("4.Go to Home Menu");
                                                         podcastmenu = sc.nextInt();
                                                         songdao = new songdao();
                                                         switch (podcastmenu) {
                                                             // Case
                                                             case 1:
                                                                 //dispaly podcast
                                                                 System.out.println("Display all Podcast");
                                                                 List<podcast> allpodcast = podcastdaoobj.podcastlist();
                                                                 podcastOperationobj.displaypodcast(allpodcast);
                                                                 break;

                                                             // Case
                                                             case 2:
                                                                 //display songs of particular artist
                                                                 System.out.println("Enter the Celebrity name");
                                                                 String celebrity_name = bi.readLine();
                                                                 List<podcast> allpodcastByCelebrity = podcastdaoobj.podcastslistByCelebrity(celebrity_name);
                                                                 podcastOperationobj.displaypodcast(allpodcastByCelebrity);
                                                                 break;

                                                             // Case
                                                             case 3:
                                                                 //display Publish Date of particular Podcase
                                                                 System.out.println("Enter the podcast name");
                                                                 String podcast_name = bi.readLine();
                                                                 Date publish_date = podcastdaoobj.podcastPublishDate(podcast_name);
                                                                 System.out.println(podcast_name + " is released on " + publish_date);
                                                                 break;


                                                             case 4:
                                                                 System.out.println("Go to Main Menu");
                                                                 // Default case
                                                             default:
                                                                 System.out.println("Enter correct choice");
                                                         }

                                                     }
                                                     while (podcastmenu != 4);
                                                     break;
                                                 }

                                                 case 3: {
                                                     do {
                                                         System.out.println("1.Creating a playlist");
                                                         System.out.println("2.Display Existing playlist and play");
                                                         System.out.println("3.Adding a song or podcast in a playlist");
                                                         System.out.println("4.Delete a song from playlist");
                                                         System.out.println("5.Go to Main Menu");
                                                         pllimenu = sc.nextInt();
                                                         switch (pllimenu) {
                                                             case 1: {
                                                                 System.out.println("Enter a name of new playlist");
                                                                 String playlistName = sc.next();
                                                                 playlistdao.insertintoPlaylist(u.getUserId(), null, playlistName);
                                                                 break;
                                                             }

                                                             // Case
                                                             case 2: {
                                                                 try {
                                                                         System.out.println("Enter a playlist name to display its songs");
                                                                         String playlistNm = sc.next();
                                                                         List<Audios> playlistSongs = playlistdao.getSongsByPlaylistName(playlistNm);
                                                                         System.out.println("-----------------------Songs in playlist " + playlistNm + "------------------------------");
                                                                         PlaylistOperation.displayplaylist(playlistSongs);
                                                                         System.out.println("Do you want to play songs in playlist 1.Yes   2.NO");
                                                                         audioPlayer audioPlayerobj = new audioPlayer();
                                                                         playsongs = sc.nextInt();

                                                                         switch (playsongs) {
                                                                             case 1: {
                                                                                 audioPlayerobj.playSong(playlistSongs);
                                                                                 sc = new Scanner(System.in);
                                                                                 int c;

                                                                                 do {
                                                                                     System.out.printf("%25s%25s%25s%25s%25s%25s%25s%25s%25s", "1. PAUSE", "2. RESUME", "3.RESTART", "4.STOP", "5.NEXT", "6.PREVIOUS", "7.Next Podcast", "8.Previous Podcast", "9.Exit");
                                                                                     System.out.println();
                                                                                     c = sc.nextInt();
                                                                                     audioPlayerobj.gotoChoice(c);
                                                                                     if (c == 4) {
                                                                                         break;
                                                                                     }

                                                                                 }
                                                                                 while (c != 9);
                                                                                 break;
                                                                             }
                                                                             case 2:
                                                                                 break;
                                                                         }


                                                                 }catch(PlayListNotFoundException P){
                                                                     System.out.println("Playlist Not Found");
                                                                 }
                                                                 break;
                                                             }
                                                             // Case
                                                             case 3: {
                                                                 int choice;
                                                                 do {
                                                                     //add songs or podcast in a playlist
                                                                     System.out.println("1.Insert a Song in a playlist");
                                                                     System.out.println("2.Insert a podcast in a playlist");
                                                                     System.out.println("3.Back");
                                                                      choice = sc.nextInt();
                                                                     switch (choice) {
                                                                         case 1: {
                                                                             System.out.println("Enter the name of  playlist");
                                                                             String PlaylistNm = sc.next();
                                                                             System.out.println("Enter the name of song to add in playlist");
                                                                             String songName = bi.readLine();
                                                                             List<song> songList = songdao.songslist();
                                                                             List<audio> audioList = playlistdao.audioList();
                                                                             for (song s : songList) {
                                                                                 if (songName.equalsIgnoreCase(s.getSong_name())) {
                                                                                     String song_id = s.getSong_id();
                                                                                     for (audio a : audioList) {
                                                                                         if (song_id.equalsIgnoreCase(a.getSong_id())) {
                                                                                             String audio_id = a.getAudio_id();
                                                                                             playlistdao.insertintoPlaylist(u.getUserId(), audio_id, PlaylistNm);
                                                                                         }

                                                                                     }
                                                                                 }
                                                                             }
                                                                             break;
                                                                         }
                                                                         case 2: {
                                                                             System.out.println("Enter the name of  playlist");
                                                                             String PlaylistNm = sc.next();
                                                                             System.out.println("Enter the name of podcast to add in playlist");
                                                                             String podcastName = bi.readLine();
                                                                             List<podcast> podcastList = podcastdao.podcastlist();
                                                                             List<audio> audioList = playlistdao.audioList();
                                                                             for (podcast p : podcastList) {
                                                                                 if (podcastName.equalsIgnoreCase(p.getPodcastName())) {
                                                                                     String podcast_id = p.getPodcastId();
                                                                                     for (audio a : audioList) {
                                                                                         if (podcast_id.equalsIgnoreCase(a.getPodcast_id())) {
                                                                                             String audio_id = a.getAudio_id();
                                                                                             playlistdao.insertintoPlaylist(u.getUserId(), audio_id, PlaylistNm);
                                                                                         }

                                                                                     }
                                                                                 }
                                                                             }
                                                                             break;
                                                                         }
                                                                         case 3:
                                                                             break;
                                                                     }
                                                                 }
                                                                 while(choice!=3);
                                                                 break;
                                                             }
                                                             // Case
                                                             case 4: {
                                                                 List<song> songli=songdao.songslist();
                                                                 List<audio> audioli=playlistdao.audioList();
                                                                 System.out.println("Enter a song name to delete");
                                                                 String songname = bi.readLine();
                                                                 //Code to get audio id from audio table with given song name in song table
                                                                 for(song s:songli) {
                                                                     if(s.getSong_name().equalsIgnoreCase(songname)){
                                                                         String song_id=s.getSong_id();
                                                                         for(audio a:audioli){
                                                                             if(a.getSong_id()!=null) {
                                                                                 if (a.getSong_id().equalsIgnoreCase(song_id)) {
                                                                                     String audioid = a.getAudio_id();
                                                                                     playlistdao.deleteSongFromPlaylist(audioid);
                                                                                 }
                                                                             }
                                                                         }
                                                                     }
                                                                 }
                                                                 break;
                                                             }

                                                             case 5: {
                                                                 break;
                                                             }

                                                             // Default case
                                                             default:
                                                                 System.out.println("Enter correct choice");
                                                         }

                                                     }
                                                     while (pllimenu != 5);
                                                     break;

                                                 }

                                                 case 4:{
                                                     System.out.println("Thankyou for using jukebox");
                                                     break;
                                                 }

                                             }
                                         }while(mainmenu!=4);
                                     }


                                }
                            }
                            if (!flag) {
                                System.out.println("Enter Correct userName and password");
                            }
                            break;

                        case 2:
                            System.out.println("Enter a userName");
                            String username = sc.next();
                            System.out.println("Enter a password");
                            String passwd = sc.next();
                            userdaoobj.addUser(username, passwd);

                    }
                }

    }
}

