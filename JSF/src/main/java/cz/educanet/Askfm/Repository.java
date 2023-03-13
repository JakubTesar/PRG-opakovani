package cz.educanet.Askfm;

import cz.educanet.Stock.Stock;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class Repository {
    private final String salt = "6974885Nk_nd.%efů!){[[420*-+";
    @Inject
    private Service service;

    public void createUserAsk(String name, String password, String email, String bio, int picture) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "INSERT INTO jews2.user(email, hashedPassword, fullName, bio, picture, createdAt, updatedAt) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)");
        ) {
            pS.setString(1, email);
            pS.setString(2, DigestUtils.sha256Hex(password + salt));
            pS.setString(3, name);
            pS.setString(4, bio);
            pS.setInt(5, picture);
            pS.setString(6, LocalDateTime.now().toString());
            pS.setString(7, LocalDateTime.now().toString());
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(String password, String email) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT u.userId, email, hashedPassword, fullName, bio, picture, createdAt, updatedAt " +
                                "FROM jews2.user u " +
                                "WHERE u.hashedPassword = ? AND u.email = ?")
        ) {
            pS.setString(1, DigestUtils.sha256Hex(password + salt));
            pS.setString(2, email);
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                service.getLoginUser().setUserId(resultSet.getInt(1));
                service.getLoginUser().setEmail(resultSet.getString(2));
                service.getLoginUser().setHashedPassword(resultSet.getString(3));
                service.getLoginUser().setFullName(resultSet.getString(4));
                service.getLoginUser().setBio(resultSet.getString(5));
                service.getLoginUser().setPicture(resultSet.getInt(6));
                service.getLoginUser().setCreatedAt(resultSet.getString(7));
                service.getLoginUser().setUpdatedAt(resultSet.getString(8));
                service.getLoginUser().setLogged(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AskUser getAskUserById() {
        AskUser user = new AskUser();
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT u.userId, email, hashedPassword, fullName, bio, picture, createdAt, updatedAt " +
                                "FROM jews2.user u " +
                                "WHERE u.userId = ? ");
        ) {
            pS.setInt(1, Integer.parseInt(service.getIDParam()));
            ResultSet resultSet = pS.executeQuery();
            user.setUserId(Integer.parseInt(service.getIDParam()));
            user.setEmail(resultSet.getString(2));
            user.setHashedPassword(resultSet.getString(3));
            user.setFullName(resultSet.getString(4));
            user.setBio(resultSet.getString(5));
            user.setPicture(resultSet.getInt(6));
            user.setEmail(resultSet.getString(7));
            user.setEmail(resultSet.getString(8));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
