package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLTables {

    //Attributes
    @XmlElement(name = "table")
    private List<XMLTable> XMLTables;

    //Constructors
    protected XMLTables() {
    }

    protected XMLTables(List<XMLTable> XMLTables) {
        this.XMLTables = XMLTables;
    }

    //Getters and Setters
    protected List<XMLTable> getXMLTables() {
        return XMLTables;
    }

    protected void setXMLTables(List<XMLTable> XMLTables) {
        this.XMLTables = XMLTables;
    }
}
