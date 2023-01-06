package audio;
import entity.Audios;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class audioPlayer
{
    List<Audios> playListSongs;
    static String status;
    Long currentFrame;
    Clip clip;

    File file;

    String filePath;


    public audioPlayer() throws SQLException, ClassNotFoundException {

    }
    ListIterator<Audios> listIterator ;

    public void filePlay(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = songPath;
        Scanner sc = new Scanner(System.in);
        file = new File(filePath);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playSong(List<Audios> playListSongs) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.playListSongs=playListSongs;
        listIterator=playListSongs.listIterator();
        filePlay(listIterator.next().getSong().getSong_url());
        clip.start();
        status = "play";
    }

    public void playPodcast() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        filePlay(listIterator.next().getPod().getPodcastPath());
        clip.start();
        status = "play";
    }

    public void pause()
    {
        if (status.equals("pause"))
        {
            System.out.println("Audio is already paused");
        }
        //it obtains the current position in the audio data ,in microposition
        this.currentFrame = this.clip.getMicrosecondPosition();
        System.out.println("Song stopped :: " + this.currentFrame + " ms");
        clip.stop();
        status = "pause";
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void resume() throws UnsupportedAudioFileException, LineUnavailableException, IOException, SQLException {
        if (status.equals("play"))
        {
            System.out.println("Audio is already being played");
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        System.out.println(" play Song (Current Frame)  :: "+this.currentFrame+ " ms.");
        clip.start();
    }

    public  void nextSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (listIterator.hasNext())
        {
            filePlay(listIterator.next().getSong().getSong_url());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("There is no more files");
        }

    }
    public  void nextPodcast() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (listIterator.hasNext())
        {
            filePlay(listIterator.next().getPod().getPodcastPath());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("There is no more files");
        }

    }

    public  void prevSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (listIterator.hasPrevious()) {
            filePlay(listIterator.previous().getSong().getSong_url());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("This is the first file");
        }
    }

    public  void prevPodcast() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (listIterator.hasPrevious()) {
            filePlay(listIterator.previous().getPod().getPodcastPath());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("This is the first file");
        }
    }

    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        clip.start();
    }

    public void stop(){
        System.out.println(" Current Frame Stop at :: "+this.currentFrame+ " ms.");
        currentFrame = 0L;
        clip.stop();

        clip.close();
    }

    public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException {
        switch (c)
        {
            case 1:
                pause();
                break;
            case 2:
                resume();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
            case 5:
                nextSong();
                break;
            case 6:
                prevSong();
                break;
            case 7:
                nextPodcast();
                break;
            case 8:
                prevPodcast();
                break;
            case 9:
                clip.stop();
                break;
        }

    }
}
