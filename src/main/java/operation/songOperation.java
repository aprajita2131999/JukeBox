package operation;

import customexceptions.songsNotFoundException;
import dao.songdao;
import entity.song;
import java.sql.SQLException;
import java.util.List;


public class songOperation {
    public static void displaysongs(List<song> songs) throws SQLException, ClassNotFoundException {
        System.out.printf("%25s%25s%25s%25s%25s%25s", "Song Id", "Song Name", "Song Duration","Genre","Album Name", "Artist Name");
        System.out.println();
        for (int i = 0; i < songs.size(); i++) {
            System.out.printf("%25s%25s%25s%25s%25s%25s", songs.get(i).getSong_id(), songs.get(i).getSong_name(), songs.get(i).getDuration(), songs.get(i).getSong_genre(), songs.get(i).getAlbum_name(), songs.get(i).getArtist_name());
            System.out.println();
        }
    }


    public List<song> songsListByArtist(String artist_name) throws SQLException, songsNotFoundException {
        return songdao.songslist().stream().filter(a->a.getArtist_name().equalsIgnoreCase(artist_name)).sorted((a,b)->a.getSong_name().compareToIgnoreCase(b.getSong_name())).toList();

    }
    public List<song> songsListByAlbum(String album_name) throws SQLException {
        return songdao.songslist().stream().filter(a -> a.getAlbum_name().equalsIgnoreCase(album_name)).sorted((a, b) -> a.getSong_name().compareToIgnoreCase(b.getSong_name())).toList();
    }

    public List<song> songsListByGenre(String genre_name) throws SQLException{
        return songdao.songslist().stream().filter(a -> a.getSong_genre().equalsIgnoreCase(genre_name)).sorted((a, b) -> a.getSong_name().compareToIgnoreCase(b.getSong_name())).toList();
    }
}







