package adapters;

import entities.User;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by ghali on 3/5/2016.
 */
public class UserAdapter extends XmlAdapter<User,User> {
    @Override
    public User unmarshal(User v) throws Exception {
        return v;
    }

    @Override
    public User marshal(User v) throws Exception {
        return v;
    }
}
