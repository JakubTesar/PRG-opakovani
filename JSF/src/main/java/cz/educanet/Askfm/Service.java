package cz.educanet.Askfm;

import cz.educanet.Users.LoginUser;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Part;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.*;
import java.util.Map;

@Named
@SessionScoped
public class Service implements Serializable {
    @Inject
    private AskUser loginAskUser;

    public void before() throws IOException {
        if (!loginAskUser.isLogged()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
    }

    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        this.loginAskUser = new AskUser();

    }

    public AskUser getLoginUser() {
        return loginAskUser;
    }

    public String getIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("userId");
    }

    public String getQuestionIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("questionId");
    }

    public String uploadFile(Part file, int userID) throws IOException, MessagingException {
        boolean file1Success = false;
        if (file != null && file.getSize() > 0) {
            String fileName = getFileNameFromPart(file);
            new File("images/").mkdirs();
            File savedFile = new File("images/", ""+userID);
            try (InputStream input = file.getInputStream()) {
                Files.copy(input, savedFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            file1Success = true;
        }
        return null;
    }
    public static String getFileNameFromPart(Part part) throws MessagingException {
        final String partHeader = String.valueOf(part.getHeader("content-disposition"));
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


}
