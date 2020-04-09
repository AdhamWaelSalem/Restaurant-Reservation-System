package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLDish {

    //Attributes
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "price")
    private int price;
    @XmlElement(name = "type")
    private String type;

    //Constructors
    protected XMLDish() {
    }

    protected XMLDish(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    //Getters and Setters
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
