package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ghalib on 3/5/2016.
 *
 */
@XmlRootElement
@Entity
@Table(name = "reviews", schema = "tut_hub_server_db", catalog = "")
public class Review {
    private int reviewsId;
    private String data;
    private Integer rating;
    private Course course;
    private String username;

    @Id
    @Column(name = "reviews_id")
    public int getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(int reviewsId) {
        this.reviewsId = reviewsId;
    }

    @Basic
    @Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (reviewsId != review.reviewsId) return false;
        if (data != null ? !data.equals(review.data) : review.data != null) return false;
        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;
        return course != null ? course.equals(review.course) : review.course == null && (username != null ? username.equals(review.username) : review.username == null);

    }

    @Override
    public int hashCode() {
        int result = reviewsId;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
