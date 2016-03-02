package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ghali on 3/2/2016.
 */
@Entity
@Table(name = "questions", schema = "tut_hub_server_db", catalog = "")
public class Question {
    private int questionId;
    private String data;
    private int videoId;
    private String username;

    @Id
    @Column(name = "question_id")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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
    @Column(name = "video_id")
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != question.questionId) return false;
        if (videoId != question.videoId) return false;
        if (data != null ? !data.equals(question.data) : question.data != null) return false;
        if (username != null ? !username.equals(question.username) : question.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + videoId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
