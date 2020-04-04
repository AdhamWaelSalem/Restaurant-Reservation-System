package XMLPack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLUsers {

    //Attributes
    @XmlElement(name = "user")
    private List<XMLUser> XMLUsers;

    //Constructors
    protected XMLUsers() {
    }

    protected XMLUsers(List<XMLUser> XMLUsers) {
        this.XMLUsers = XMLUsers;
    }

    //Getters and Setters
    protected List<XMLUser> getXMLUsers() {
        return XMLUsers;
    }

    protected void setXMLUsers(List<XMLUser> XMLUsers) {
        this.XMLUsers = XMLUsers;
    }
}
