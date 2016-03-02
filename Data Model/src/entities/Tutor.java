package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ghalib on 3/2/2016.
 */
@XmlRootElement
@Entity
@Table(name = "tutors", schema = "tut_hub_server_db", catalog = "")
@IdClass(TutorPK.class)
public class Tutor {
    private String tutorId;
    private String email;
    private String password;
    private String name;
    private String description;
    private String address;

    @Id
    @Column(name = "tutor_id")
    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tutor tutor = (Tutor) o;

        if (tutorId != null ? !tutorId.equals(tutor.tutorId) : tutor.tutorId != null) return false;
        if (email != null ? !email.equals(tutor.email) : tutor.email != null) return false;
        if (password != null ? !password.equals(tutor.password) : tutor.password != null) return false;
        if (name != null ? !name.equals(tutor.name) : tutor.name != null) return false;
        if (description != null ? !description.equals(tutor.description) : tutor.description != null) return false;
        if (address != null ? !address.equals(tutor.address) : tutor.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tutorId != null ? tutorId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
