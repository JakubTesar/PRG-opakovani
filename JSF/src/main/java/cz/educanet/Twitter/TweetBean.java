package cz.educanet.Twitter;

import cz.educanet.Stock.Stock;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@Named
@ApplicationScoped

public class TweetBean {
    public ArrayList<Tweet> getTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/twitter?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT t.tweet_id, content, author, likes, created_at, updated_at " +
                                "FROM twitter.tweets t ")
        ) {

            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                Tweet tweet = new Tweet();
                tweet.setTweetID(resultSet.getInt(1));
                tweet.setContent(resultSet.getString(2));
                tweet.setAuthor(resultSet.getString(3));
                tweet.setLikes(resultSet.getInt(4));
                tweet.setCreatedAt(resultSet.getString(5));
                tweet.setUpdatedAt(resultSet.getString(6));
                tweets.add(tweet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tweets;
    }
    public void editTweet(String content, String author) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/twitter?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "UPDATE  twitter.tweets " +
                                "SET  twitter.tweets.content = ?, twitter.tweets.author = ?, twitter.tweets.updated_at = ? " +
                                "WHERE tweet_id = ?");) {
            pS.setString(1, content);
            pS.setString(2, author);
            pS.setString(3, LocalDateTime.now().toString());
            pS.setInt(4, Integer.parseInt(getIDParam()));
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createTweet(String content, String author) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/twitter?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "INSERT INTO twitter.tweets (tweets.content, tweets.author, tweets.created_at, tweets.updated_at )" +
                                "VALUES (?, ?, ?, ?)");
        ) {
            pS.setString(1, content);
            pS.setString(2, author);
            pS.setString(3, LocalDateTime.now().toString());
            pS.setString(4, LocalDateTime.now().toString());
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteTweet(int id) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/twitter?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "DELETE FROM twitter.tweets " +
                                "WHERE tweets.tweet_id = ?;")) {
            pS.setInt(1, id);
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addLike(int id) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/twitter?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "UPDATE  twitter.tweets " +
                                "SET  twitter.tweets.likes = twitter.tweets.likes  + 1 " +
                                "WHERE tweet_id = ?")) {
            pS.setInt(1, id);
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String getIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("tweetID");
    }

}
