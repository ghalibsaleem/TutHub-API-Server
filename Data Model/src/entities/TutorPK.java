package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ghali on 3/2/2016.
 */
public class TutorPK implements Serializable {
    private String tutorId;
    private String email;

    @Column(name = "tutor_id")
    @Id
    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    @Column(name = "email")
    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutorPK tutorPK = (TutorPK) o;

        if (tutorId != null ? !tutorId.equals(tutorPK.tutorId) : tutorPK.tutorId != null) return false;
        if (email != null ? !email.equals(tutorPK.email) : tutorPK.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tutorId != null ? tutorId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
