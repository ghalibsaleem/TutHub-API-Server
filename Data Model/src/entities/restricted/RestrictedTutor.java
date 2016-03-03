package entities.restricted;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ghalib on 3/3/2016.
 */
@XmlRootElement(name = "Tutor")
public class RestrictedTutor {
    private String tutorId;
    private String name;
    private String description;
    private String address;

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RestrictedTutor() {
    }

    public RestrictedTutor(String tutorId, String name, String description, String address) {
        this.tutorId = tutorId;
        this.name = name;
        this.description = description;
        this.address = address;
    }
}
