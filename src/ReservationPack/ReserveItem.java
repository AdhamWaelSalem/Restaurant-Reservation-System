package ReservationPack;

public abstract class ReserveItem {
    public boolean reserved;
    public void Reserve(){
        this.reserved = true;
    }
    public void Free(){
        this.reserved = false;
    }
    public String info(){return null;}
}
