package org.tuthub.api.authorizationmodel;

import entities.Tutor;
import entities.Video;

/**
 * Created by ghalib on 3/5/2016.
 *
 */
public class TutorVideo {
    private Tutor tutor;
    private Video video;

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
