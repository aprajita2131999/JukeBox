package entity;

public class playlist {

int playlistId;
String userId;
String audioId;
String playlistName;

    public playlist(int playlistId, String userId, String audioId, String playlistName) {
        this.playlistId = playlistId;
        this.userId = userId;
        this.audioId = audioId;
        this.playlistName = playlistName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return "playlist{" +
                "playlistId=" + playlistId +
                ", userId='" + userId + '\'' +
                ", audioId='" + audioId + '\'' +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }
}
