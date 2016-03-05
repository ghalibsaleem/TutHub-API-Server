package org.tuthub.api.authorizationmodel;

import entities.Course;
import entities.Tutor;
import entities.User;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ghalib on 3/5/2016.
 */

@XmlRootElement
public class AuthCourse {
    private Tutor tutor;
    private Course course;

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
