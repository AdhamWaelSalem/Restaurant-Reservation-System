package ReservationPack;

import java.util.Random;

public class Table extends ReserveItem {

    private int number;
    private int numberOfSeats;
    private boolean smoking;

    public enum Location {
        Indoors,
        Outdoors
    }

    private Location location;

    public static Location randomLocation() {
        Random random = new Random();
        return Location.values()[random.nextInt(Location.values().length)];
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public Location getLocation() {
        return location;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    ////

    public String info() {
        String info, smoking = "Non Smoking";
        if (this.smoking)
            smoking = "Smoking";
        info = "Table " + this.number + "\n" +
                this.numberOfSeats + " Seats\n" +
                smoking + "\n" + location.toString();
        return info;
    }
}
