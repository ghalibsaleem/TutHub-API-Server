package entities;

import javax.persistence.*;

/**
 * Created by ghali on 3/2/2016.
 */
@Entity
@Table(name = "reviews", schema = "tut_hub_server_db", catalog = "")
public class Review {
    private int reviewsId;
    private String data;
    private int courseId;
    private String username;
    private Integer rating;

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
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (courseId != review.courseId) return false;
        if (data != null ? !data.equals(review.data) : review.data != null) return false;
        if (username != null ? !username.equals(review.username) : review.username != null) return false;
        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewsId;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + courseId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
