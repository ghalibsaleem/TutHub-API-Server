package adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by ghali on 3/3/2016.
 */
public class PasswordAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return null;
    }
}
