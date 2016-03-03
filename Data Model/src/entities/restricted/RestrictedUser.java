package entities.restricted;

import entities.User;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by ghalib on 3/3/2016.
 */

@XmlRootElement(name = "User")
public class RestrictedUser {
    private String username;
    private String name;
    private String gender;
    private Date dob;
    private String address;
    private String mobileno;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public RestrictedUser() {
    }

    public RestrictedUser(String username, String name, String gender, Date dob, String address, String mobileno) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.mobileno = mobileno;
    }

    public RestrictedUser(User user){
        username = user.getUsername();
        name = user.getName();
        gender = user.getGender();
        dob = user.getDob();
        address = user.getAddress();
        mobileno = user.getMobileno();
    }
}
