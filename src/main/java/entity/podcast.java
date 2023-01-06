package entity;

import java.sql.Date;

public class podcast {

    String podcastId;
    String podcastName;
    String celebrityName;
    Date publishDate;
    String podcastPath;

    public podcast(String podcastId, String podcastName, String celebrityName, Date publishDate, String podcastPath) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.celebrityName = celebrityName;
        this.publishDate = publishDate;
        this.podcastPath = podcastPath;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPodcastPath() {
        return podcastPath;
    }

    public void setPodcastPath(String podcastPath) {
        this.podcastPath = podcastPath;
    }

    @Override
    public String toString() {
        return "podcast{" +
                "podcastId='" + podcastId + '\'' +
                ", podcastName='" + podcastName + '\'' +
                ", celebrityName='" + celebrityName + '\'' +
                ", publishDate=" + publishDate +
                ", podcastPath='" + podcastPath + '\'' +
                '}';
    }
}
