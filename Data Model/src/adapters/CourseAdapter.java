package adapters;

import entities.Course;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by ghali on 3/5/2016.
 */
public class CourseAdapter extends XmlAdapter<Course,Course> {
    @Override
    public Course unmarshal(Course v) throws Exception {
        return v;
    }

    @Override
    public Course marshal(Course v) throws Exception {
        return v;
    }
}
