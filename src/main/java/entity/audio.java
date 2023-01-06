package entity;

public class audio {

    String audio_id;
    String song_id;
    String podcast_id;
    int type;



    public audio(String audio_id, String song_id, String podcast_id, int type) {
        this.audio_id = audio_id;
        this.song_id = song_id;
        this.podcast_id = podcast_id;
        this.type = type;
    }

    public String getAudio_id() {
        return audio_id;
    }

    public void setAudio_id(String audio_id) {
        this.audio_id = audio_id;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(String podcast_id) {
        this.podcast_id = podcast_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "audio{" +
                "audio_id=" + audio_id +
                ", song_id=" + song_id +
                ", podcast_id=" + podcast_id +
                ", type=" + type +
                '}';
    }
}
