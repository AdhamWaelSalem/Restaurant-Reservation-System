package ReservationPack;

public abstract class ReserveItem {

    //Attributes
    protected boolean reserved;
    protected boolean major;

    //Constructor


    //Methods
    public void Reserve(){
        reserved = true;
    }
    public void Free(){
        reserved = false;
    }
    public boolean isReserved() {
        return reserved;
    }
    public boolean isMajor() {
        return major;
    }
}
