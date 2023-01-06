package operation;

import entity.podcast;
import entity.song;

import java.sql.SQLException;
import java.util.List;

public class podcastOperation {
    public void displaypodcast(List<podcast> podcasts) throws SQLException,ClassNotFoundException {
        System.out.printf("%25s%25s%25s%25s", "Podcast Id", "Podcast Name", "Celebrity", "Date of Release");
        System.out.println();
        for(int i=0;i<podcasts.size();i++){
            System.out.printf("%25s%25s%25s%25s", podcasts.get(i).getPodcastId() , podcasts.get(i).getPodcastName(), podcasts.get(i).getCelebrityName(), podcasts.get(i).getPublishDate());
            System.out.println();
        }
    }
}
