package cz.educanet.Users;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.time.LocalDateTime;

@Named
@SessionScoped
public class UsersBean implements Serializable {
    private LoginUser loginUser = new LoginUser();
    private final String salt = "6974885Nk_nd.%efů!){[[420*-+";

    public boolean before() throws IOException {
        if (loginUser.isLogged()){
            return true;
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            return false;
        }
    }

    public void createUserAuthen(String name, String password, String email) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/users?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "INSERT INTO users.user (fullName, email, hashedPassword, createdAt, updatedAt )" +
                                "VALUES (?, ?, ?, ?, ?)");
        ) {
            pS.setString(1, name);
            pS.setString(2, email);
            pS.setString(3, DigestUtils.sha256Hex(password+salt));
            pS.setString(4, LocalDateTime.now().toString());
            pS.setString(5, LocalDateTime.now().toString());
            pS.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void login(String password, String email) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/users?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT u.userId, fullName, email, hashedPassword, createdAt, updatedAt " +
                                "FROM users.user u " +
                                "WHERE u.hashedPassword = ? AND u.email = ?")
        ) {
            pS.setString(1, DigestUtils.sha256Hex(password+salt));
            pS.setString(2, email);
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                loginUser.setUserId(resultSet.getInt(1));
                loginUser.setFullName(resultSet.getString(2));
                loginUser.setEmail(resultSet.getString(3));
                loginUser.setHashedPassword(resultSet.getString(4));
                loginUser.setCreatedAt(resultSet.getString(5));
                loginUser.setUpdatedAt(resultSet.getString(6));
                loginUser.setLogged(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void logout() {
       this.loginUser = new LoginUser();
    }

    public LoginUser getLoginUser() {

        return loginUser;
    }
}
