package cz.educanet.Twitter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jdk.jfr.Name;

@Named
@ApplicationScoped
public class Tweet {
    private int tweetID;
    private String content;
    private String author;
    private int likes;
    private String createdAt;
    private String updatedAt;


    public int getTweetID() {
        return tweetID;
    }

    public void setTweetID(int tweetID) {
        this.tweetID = tweetID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
