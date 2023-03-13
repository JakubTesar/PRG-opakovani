package cz.educanet.Askfm;

import cz.educanet.Users.LoginUser;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.util.Map;

@Named
@SessionScoped
public class Service implements Serializable {
    private AskUser loginAskUser = new AskUser();

    public void before() throws IOException {
        if (!loginAskUser.isLogged()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
    }

    public void logout() {
        this.loginAskUser = new AskUser();
    }

    public AskUser getLoginUser() {
        return loginAskUser;
    }

    public String getIDParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("userId");
    }

}
