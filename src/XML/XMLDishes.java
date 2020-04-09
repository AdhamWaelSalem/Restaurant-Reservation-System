package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLDishes {

    //Attributes
    @XmlElement(name = "dish")
    private List<XMLDish> XMLDishes;

    //Constructors
    protected XMLDishes() {
    }

    protected XMLDishes(List<XMLDish> XMLDishes) {
        this.XMLDishes = XMLDishes;
    }

    //Getters and Setters
    protected List<XMLDish> getXMLDishes() {
        return XMLDishes;
    }

    protected void setXMLDishes(List<XMLDish> XMLDishes) {
        this.XMLDishes = XMLDishes;
    }
}
