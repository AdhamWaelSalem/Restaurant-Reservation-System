package XMLPack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
class XMLTable {

    //Attributes
    @XmlElement(name = "number")
    private int number;
    @XmlElement(name = "number_of_seats")
    private int numberOfSeats;
    @XmlElement(name = "smoking")
    private Boolean smoking;

    //Constructors
    protected XMLTable() {
    }

    protected XMLTable(int number, int numberOfSeats, Boolean smoking) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
        this.smoking = smoking;
    }

    //Getters and Setters
    protected int getNumber() {
        return number;
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    protected int getNumberOfSeats() {
        return numberOfSeats;
    }

    protected void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    protected Boolean getSmoking() {
        return smoking;
    }

    protected void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }
}
