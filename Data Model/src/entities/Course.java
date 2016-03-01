package entities;

import javax.persistence.*;

/**
 * Created by ghali on 3/2/2016.
 */
@Entity
@Table(name = "courses", schema = "tut_hub_server_db", catalog = "")
public class Course {
    private int courseId;
    private String name;
    private String type;
    private String description;
    private Byte isCertification;
    private Byte isExam;
    private String tutorId;
    private String tags;
    private String excersiceUrl;
    private Integer rating;
    private Byte isVerified;

    @Id
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "is_certification")
    public Byte getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(Byte isCertification) {
        this.isCertification = isCertification;
    }

    @Basic
    @Column(name = "is_exam")
    public Byte getIsExam() {
        return isExam;
    }

    public void setIsExam(Byte isExam) {
        this.isExam = isExam;
    }

    @Basic
    @Column(name = "tutor_id")
    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "excersice_url")
    public String getExcersiceUrl() {
        return excersiceUrl;
    }

    public void setExcersiceUrl(String excersiceUrl) {
        this.excersiceUrl = excersiceUrl;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "is_verified")
    public Byte getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Byte isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (type != null ? !type.equals(course.type) : course.type != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (isCertification != null ? !isCertification.equals(course.isCertification) : course.isCertification != null)
            return false;
        if (isExam != null ? !isExam.equals(course.isExam) : course.isExam != null) return false;
        if (tutorId != null ? !tutorId.equals(course.tutorId) : course.tutorId != null) return false;
        if (tags != null ? !tags.equals(course.tags) : course.tags != null) return false;
        if (excersiceUrl != null ? !excersiceUrl.equals(course.excersiceUrl) : course.excersiceUrl != null)
            return false;
        if (rating != null ? !rating.equals(course.rating) : course.rating != null) return false;
        if (isVerified != null ? !isVerified.equals(course.isVerified) : course.isVerified != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isCertification != null ? isCertification.hashCode() : 0);
        result = 31 * result + (isExam != null ? isExam.hashCode() : 0);
        result = 31 * result + (tutorId != null ? tutorId.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (excersiceUrl != null ? excersiceUrl.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (isVerified != null ? isVerified.hashCode() : 0);
        return result;
    }
}
