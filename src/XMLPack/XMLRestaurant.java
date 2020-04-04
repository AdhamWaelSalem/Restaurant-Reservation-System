package XMLPack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLRestaurant {

    //Attributes
    @XmlElement(name = "users")
    private XMLUsers XMLUsers;
    @XmlElement(name = "tables")
    private XMLTables XMLTables;
    @XmlElement(name = "dishes")
    private XMLDishes XMLDishes;

    //Constructors
    protected XMLRestaurant() {
    }

    protected XMLRestaurant(XMLUsers XMLUsers, XMLTables XMLTables, XMLDishes XMLDishes) {
        this.XMLUsers = XMLUsers;
        this.XMLTables = XMLTables;
        this.XMLDishes = XMLDishes;
    }

    //Getters and Setters
    protected XMLUsers getXMLUsers() {
        return XMLUsers;
    }

    protected void setXMLUsers(XMLUsers XMLUsers) {
        this.XMLUsers = XMLUsers;
    }

    protected XMLTables getXMLTables() {
        return XMLTables;
    }

    protected void setXMLTables(XMLTables XMLTables) {
        this.XMLTables = XMLTables;
    }

    protected XMLDishes getXMLDishes() {
        return XMLDishes;
    }

    protected void setXMLDishes(XMLDishes XMLDishes) {
        this.XMLDishes = XMLDishes;
    }

}
