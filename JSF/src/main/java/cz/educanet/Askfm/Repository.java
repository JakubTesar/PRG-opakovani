package cz.educanet.Askfm;

import cz.educanet.Stock.Stock;
import cz.educanet.gapminder.GapminderBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Part;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class Repository {
    private final String salt = "6974885Nk_nd.%efů!){[[420*-+";
    @Inject
    private Service service;

    public void createUserAsk(String name, String password, String email, String bio, int picture, Part file) throws MessagingException, IOException {
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
      //  service.uploadFile(file, 1);
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

    public AskUser getAskUserByIdQParam() {
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
            while (resultSet.next()) {
                user.setUserId(Integer.parseInt(service.getIDParam()));
                user.setEmail(resultSet.getString(2));
                user.setHashedPassword(resultSet.getString(3));
                user.setFullName(resultSet.getString(4));
                user.setBio(resultSet.getString(5));
                user.setPicture(resultSet.getInt(6));
                user.setCreatedAt(resultSet.getString(7));
                user.setUpdatedAt(resultSet.getString(8));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createQuestion(int target, String question) {
        if (service.getLoginUser().isLogged()) {
            try (
                    Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                    PreparedStatement pS = c.prepareStatement(
                            "INSERT INTO jews2.question(question,authorId, targetId, createdAt, updatedAt) " +
                                    "VALUES (?, ?, ?, ?,?)");
            ) {
                pS.setString(1, question);
                pS.setInt(2, service.getLoginUser().getUserId());
                pS.setInt(3, target);
                pS.setString(4, LocalDateTime.now().toString());
                pS.setString(5, LocalDateTime.now().toString());
                pS.execute();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (
                    Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                    PreparedStatement pS = c.prepareStatement(
                            "INSERT INTO jews2.question(question, targetId, createdAt, updatedAt) " +
                                    "VALUES (?, ?, ?, ?)");
            ) {
                pS.setString(1, question);
                pS.setInt(2, target);
                pS.setString(3, LocalDateTime.now().toString());
                pS.setString(4, LocalDateTime.now().toString());
                pS.execute();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT q.questionId, question, answer, authorId, targetId, createdAt, updatedAt " +
                                "FROM jews2.question q ");
        ) {
            ResultSet resultSet = pS.executeQuery();

            while (resultSet.next()) {
                Question q = new Question();
                q.setQuestionId(resultSet.getInt(1));
                q.setQuestion(resultSet.getString(2));
                q.setAnswer(resultSet.getString(3));
                q.setAuthorId(resultSet.getInt(4));
                q.setTargetId(resultSet.getInt(5));
                q.setCreatedAt(resultSet.getString(6));
                q.setUpdatedAt(resultSet.getString(7));
                questions.add(q);
            }
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AskUser getAskUserById(int Id) {
        if (Id == 0) {
            AskUser anonym = new AskUser();
            anonym.setFullName("Anonym");
            return anonym;
        } else {
            AskUser user = new AskUser();
            try (
                    Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                    PreparedStatement pS = c.prepareStatement(
                            "SELECT u.userId, email, hashedPassword, fullName, bio, picture, createdAt, updatedAt " +
                                    "FROM jews2.user u " +
                                    "WHERE u.userId = ? ");
            ) {
                pS.setInt(1, Id);
                ResultSet resultSet = pS.executeQuery();
                while (resultSet.next()) {
                    user.setUserId(Id);
                    user.setEmail(resultSet.getString(2));
                    user.setHashedPassword(resultSet.getString(3));
                    user.setFullName(resultSet.getString(4));
                    user.setBio(resultSet.getString(5));
                    user.setPicture(resultSet.getInt(6));
                    user.setCreatedAt(resultSet.getString(7));
                    user.setUpdatedAt(resultSet.getString(8));
                }
                return user;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<AskUser> getAllAskUsers() {
        ArrayList<AskUser> askUsers = new ArrayList<>();
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT u.userId, email, hashedPassword, fullName, bio, picture, createdAt, updatedAt " +
                                "FROM jews2.user u ");
        ) {
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                AskUser user = new AskUser();
                user.setUserId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setHashedPassword(resultSet.getString(3));
                user.setFullName(resultSet.getString(4));
                user.setBio(resultSet.getString(5));
                user.setPicture(resultSet.getInt(6));
                user.setCreatedAt(resultSet.getString(7));
                user.setUpdatedAt(resultSet.getString(8));
                askUsers.add(user);
            }
            return askUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Question getQuestionByIDParam() {
        Question question = new Question();
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT q.questionId, question, answer, authorId, targetId, createdAt, updatedAt " +
                                "FROM jews2.question q " +
                                "WHERE q.questionId = ? ");
        ) {
            pS.setInt(1, Integer.parseInt(service.getQuestionIDParam()));
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                question.setQuestionId(Integer.parseInt(service.getQuestionIDParam()));
                question.setQuestion(resultSet.getString(2));
                question.setAnswer(resultSet.getString(3));
                question.setAuthorId(resultSet.getInt(4));
                question.setTargetId(resultSet.getInt(5));
                question.setCreatedAt(resultSet.getString(6));
                question.setUpdatedAt(resultSet.getString(7));
            }
            return question;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void answer(String answer) throws IOException, SQLException {
        if (service.getLoginUser().isLogged()) {
            try (
                    Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE jews2.question " +
                                    "SET answer = ?, updatedAt = ?" +
                                    "WHERE questionId = ?");) {
                preparedStatement.setInt(3, Integer.parseInt(service.getQuestionIDParam()));
                preparedStatement.setString(1, answer);
                preparedStatement.setString(2, LocalDateTime.now().toString());
                Boolean ok = preparedStatement.execute();

            }
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }

    }

    public ArrayList<Question> getAllQuestionsByTarget() {
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT  q.questionId, question, answer, authorId, targetId, createdAt, updatedAt " +
                                "FROM jews2.question q " +
                                "WHERE targetId = ?");
        ) {
            pS.setInt(1, Integer.parseInt(service.getIDParam()));
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setQuestionId(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setAnswer(resultSet.getString(3));
                question.setAuthorId(resultSet.getInt(4));
                question.setTargetId(resultSet.getInt(5));
                question.setCreatedAt(resultSet.getString(6));
                question.setUpdatedAt(resultSet.getString(7));
                questions.add(question);
            }
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLikesFromQuestion(int questionId) throws SQLException {
        int count = 0;
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT COUNT(ql.questionId) " +
                                "FROM jews2.question_like ql " +
                                "WHERE ql.questionId = ?");
        ) {
            pS.setInt(1, questionId);
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        }

    }

    public void giveLike(int questionId) throws IOException, SQLException {
        if (service.getLoginUser().isLogged()) {
            int id = 0;
            try (
                    Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                    PreparedStatement pS = c.prepareStatement(
                            "SELECT ql.userId " +
                                    "FROM jews2.question_like ql " +
                                    "WHERE ql.questionId = ? AND ql.userId = ?");
            ) {
                pS.setInt(1, questionId);
                pS.setInt(2, service.getLoginUser().getUserId());
                ResultSet resultSet = pS.executeQuery();
                while (resultSet.next()) {
                    id = resultSet.getInt(1);
                }
            }
            if (id != service.getLoginUser().getUserId()) {
                try (
                        Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                        PreparedStatement pS = c.prepareStatement(
                                "INSERT INTO jews2.question_like(questionId, userId) " +
                                        "VALUES (?, ?) ");
                ) {
                    pS.setInt(1, questionId);
                    pS.setInt(2, service.getLoginUser().getUserId());
                    pS.execute();
                }
            }
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
    }

    public boolean canSeeAnswer(int questionId) throws SQLException {
        boolean bool = false;
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "SELECT q.targetId " +
                                "FROM jews2.question q " +
                                "WHERE q.questionId = ?");
        ) {
            pS.setInt(1, questionId);
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                if (service.getLoginUser().getUserId() == resultSet.getInt(1))
                    bool = true;
            }
            return bool;
        }
    }

    public void deleteQuestion(int questionId) throws SQLException {
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "DELETE FROM jews2.question_like " +
                                "WHERE question_like.questionId = ?;")
        ) {
            pS.setInt(1, questionId);
            pS.executeQuery();
        }
        try (
                Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3309/jews2?user=root&password=heslo");
                PreparedStatement pS = c.prepareStatement(
                        "DELETE FROM jews2.question " +
                                "WHERE question.questionId = ?;")
        ) {
            pS.setInt(1, questionId);
            pS.executeQuery();
        }
    }

}
