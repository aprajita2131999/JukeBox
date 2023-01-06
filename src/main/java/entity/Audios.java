package entity;

public class Audios {
    private song song;
    private podcast pod;

    public Audios(podcast pod){
        this.pod=pod;
    }

    public Audios(song song){
        this.song=song;
    }
    public entity.song getSong() {
        return song;
    }

    public void setSong(entity.song song) {
        this.song = song;
    }

    public podcast getPod() {
        return pod;
    }

    public void setPod(podcast pod) {
        this.pod = pod;
    }
}
