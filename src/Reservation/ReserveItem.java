package Reservation;

public abstract class ReserveItem {

    //Attributes
    protected boolean reserved;
    protected boolean major;

    //Constructor


    //Methods
    public void Reserve() {
        reserved = true;
    }

    public void Free() {
        reserved = false;
    }

    public String Details(){return null;}

    //Getters
    public boolean isReserved() {
        return reserved;
    }

    public boolean isMajor() {
        return major;
    }


    //Setters

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setMajor(boolean major) {
        this.major = major;
    }
}
