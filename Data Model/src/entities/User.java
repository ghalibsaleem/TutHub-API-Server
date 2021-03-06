package entities;

import adapters.PasswordAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.List;

/**
 * Created by ghalib on 3/5/2016.
 *
 */
@XmlRootElement
@Entity
@Table(name = "users", schema = "tut_hub_server_db", catalog = "")
public class User {
    private String username;
    private String email;
    private String password;
    private String name;
    private String gender;
    private Date dob;
    private String address;
    private String mobileno;
    private List<UserCourseRel> user_course_rels;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlJavaTypeAdapter(PasswordAdapter.class)
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "mobileno")
    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (dob != null ? !dob.equals(user.dob) : user.dob != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (mobileno != null ? !mobileno.equals(user.mobileno) : user.mobileno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mobileno != null ? mobileno.hashCode() : 0);
        return result;
    }

    @XmlTransient
    @OneToMany(mappedBy = "user")
    public List<UserCourseRel> getUser_course_rels() {
        return user_course_rels;
    }

    public void setUser_course_rels(List<UserCourseRel> user_course_rels) {
        this.user_course_rels = user_course_rels;
    }
}
