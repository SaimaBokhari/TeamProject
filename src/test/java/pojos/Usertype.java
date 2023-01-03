package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usertype {

    private String usertype;

    public Usertype(String usertype) {
        this.usertype = usertype;
    }

    public Usertype() {
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "Usertype{" +
                "usertype='" + usertype + '\'' +
                '}';
    }
}
