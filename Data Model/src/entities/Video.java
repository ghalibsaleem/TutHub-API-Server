package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by ghalib on 3/5/2016.
 *
 */
@XmlRootElement
@Entity
@Table(name = "videos", schema = "tut_hub_server_db", catalog = "")
public class Video {
    private int videoId;
    private String videoUrl;
    private String description;
    private String excerciseUrl;
    private List<Question> questions;
    private Course course;

    @Id
    @Column(name = "video_id")
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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
    @Column(name = "excercise_url")
    public String getExcerciseUrl() {
        return excerciseUrl;
    }

    public void setExcerciseUrl(String excerciseUrl) {
        this.excerciseUrl = excerciseUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        if (videoId != video.videoId) return false;
        if (videoUrl != null ? !videoUrl.equals(video.videoUrl) : video.videoUrl != null) return false;
        if (description != null ? !description.equals(video.description) : video.description != null) return false;
        if (excerciseUrl != null ? !excerciseUrl.equals(video.excerciseUrl) : video.excerciseUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = videoId;
        result = 31 * result + (videoUrl != null ? videoUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (excerciseUrl != null ? excerciseUrl.hashCode() : 0);
        return result;
    }

    @XmlTransient
    @OneToMany(mappedBy = "video")
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
}
