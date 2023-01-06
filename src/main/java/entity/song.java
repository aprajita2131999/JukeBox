package entity;

public class song {
   String song_id;
   String song_name;
   double duration;
   String album_name;
   String artist_name;
   String song_genre;
   String song_url;

   public song(String song_id, String song_name, double duration,String song_genre, String album_name, String artist_name, String song_url) {
      this.song_id = song_id;
      this.song_name = song_name;
      this.duration = duration;
      this.song_genre = song_genre;
      this.album_name = album_name;
      this.artist_name = artist_name;
      this.song_url = song_url;
   }

   public String getSong_id() {
      return song_id;
   }

   public void setSong_id(String song_id) {
      this.song_id = song_id;
   }

   public String getSong_name() {
      return song_name;
   }

   public void setSong_name(String song_name) {
      this.song_name = song_name;
   }

   public double getDuration() {
      return duration;
   }

   public void setDuration(double duration) {
      this.duration = duration;
   }

   public String getAlbum_name() {
      return album_name;
   }

   public void setAlbum_name(String album_name) {
      this.album_name = album_name;
   }

   public String getArtist_name() {
      return artist_name;
   }

   public void setArtist_name(String artist_name) {
      this.artist_name = artist_name;
   }

   public String getSong_genre() {
      return song_genre;
   }

   public void setSong_genre(String song_genre) {
      this.song_genre = song_genre;
   }

   public String getSong_url() {
      return song_url;
   }

   public void setSong_url(String song_url) {
      this.song_url = song_url;
   }

   @Override
   public String toString() {
      return "song{" +
              "song_id=" + song_id +
              ", song_name='" + song_name + '\'' +
              ", duration=" + duration +
              ", album_name='" + album_name + '\'' +
              ", artist_name='" + artist_name + '\'' +
              ", song_genre='" + song_genre + '\'' +
              ", song_url='" + song_url + '\'' +
              '}';
   }

   public static class audiooperation {
   }
}
