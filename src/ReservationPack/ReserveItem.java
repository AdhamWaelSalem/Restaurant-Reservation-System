package ReservationPack;

public abstract class ReserveItem {
    protected boolean reserved;
    public void Reserve(){
        this.reserved = true;
    }
    public void Free(){
        this.reserved = false;
    }
    public String info(){return null;}
    public boolean isReserved() {
        return reserved;
    }
}
