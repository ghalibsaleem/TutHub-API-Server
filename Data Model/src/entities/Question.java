package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by ghali on 3/5/2016.
 */
@XmlRootElement
@Entity
@Table(name = "questions", schema = "tut_hub_server_db", catalog = "")
public class Question {
    private int questionId;
    private String data;
    private List<Answer> answers;
    private Video video;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != question.questionId) return false;
        if (data != null ? !data.equals(question.data) : question.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @XmlTransient
    @OneToMany(mappedBy = "question")
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "video_id", nullable = false)
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
