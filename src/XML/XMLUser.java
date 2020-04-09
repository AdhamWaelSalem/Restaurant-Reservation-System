package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLUser {

    //Attributes
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "role")
    private String role;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;

    //Constructors
    protected XMLUser() {
    }

    protected XMLUser(String name, String role, String username, String password) {
        this.name = name;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    //Getters and Setters
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getRole() {
        return role;
    }

    protected void setRole(String role) {
        this.role = role;
    }

    protected String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }
}
