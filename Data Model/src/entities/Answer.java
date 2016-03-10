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
@Table(name = "answers", schema = "tut_hub_server_db", catalog = "")
public class Answer {
    private int answerId;
    private String data;
    private Integer likes;
    private Integer dislikes;
    private Question question;
    private String username;
    private String tutorId;

    @Id
    @Column(name = "answer_id")
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
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
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "dislikes")
    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answerId != answer.answerId) return false;
        if (!data.equals(answer.data)) return false;
        if (likes != null ? !likes.equals(answer.likes) : answer.likes != null) return false;
        if (dislikes != null ? !dislikes.equals(answer.dislikes) : answer.dislikes != null) return false;
        if (question != null ? !question.equals(answer.question) : answer.question != null) return false;
        if (username != null ? !username.equals(answer.username) : answer.username != null) return false;
        return tutorId != null ? tutorId.equals(answer.tutorId) : answer.tutorId == null;

    }

    @Override
    public int hashCode() {
        int result = answerId;
        result = 31 * result + data.hashCode();
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (dislikes != null ? dislikes.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (tutorId != null ? tutorId.hashCode() : 0);
        return result;
    }

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
    @Column(name = "tutor_id")
    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }
}
