package entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ghalib on 3/5/2016.
 *
 */
@Entity
@Table(name = "user_course_rel", schema = "tut_hub_server_db", catalog = "")
public class UserCourseRel {
    private int id;
    private int lectureCompleted;
    private Date registeredDate;
    private Date completionDate;
    private String certificationId;
    private Course course;
    private User user;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lecture_completed")
    public int getLectureCompleted() {
        return lectureCompleted;
    }

    public void setLectureCompleted(int lectureCompleted) {
        this.lectureCompleted = lectureCompleted;
    }

    @Basic
    @Column(name = "registered_date")
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Basic
    @Column(name = "completion_date")
    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    @Basic
    @Column(name = "certification_id")
    public String getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(String certificationId) {
        this.certificationId = certificationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCourseRel that = (UserCourseRel) o;

        if (id != that.id) return false;
        if (lectureCompleted != that.lectureCompleted) return false;
        if (registeredDate != null ? !registeredDate.equals(that.registeredDate) : that.registeredDate != null)
            return false;
        if (completionDate != null ? !completionDate.equals(that.completionDate) : that.completionDate != null)
            return false;
        return certificationId != null ? certificationId.equals(that.certificationId) : that.certificationId == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + lectureCompleted;
        result = 31 * result + (registeredDate != null ? registeredDate.hashCode() : 0);
        result = 31 * result + (completionDate != null ? completionDate.hashCode() : 0);
        result = 31 * result + (certificationId != null ? certificationId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
