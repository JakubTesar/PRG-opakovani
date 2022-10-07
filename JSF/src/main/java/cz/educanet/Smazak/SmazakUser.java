package cz.educanet.Smazak;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
@ApplicationScoped

@Named
public class SmazakUser {

    private SmazakUser smazakUser;
    private String name;
    private String adress;
    private String city;
    private int postCode;

    public String saveUser(String name, String Adress, String City, int PostCode){
        smazakUser = new SmazakUser();
        smazakUser.setName(name);
        smazakUser.setAdress(adress);
        smazakUser.setCity(city);
        smazakUser.setPostCode(postCode);
        return "./Smažák/showSmazak.xhtml";
    }
    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
