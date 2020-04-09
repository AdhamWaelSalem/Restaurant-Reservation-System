package Reservation;

import java.util.Random;

public class Table extends ReserveItem {

    //Attributes
    private int number;
    private int numberOfSeats;
    private boolean smoking;
    public enum Location {
        Indoors,
        Outdoors
    }
    private Location location;

    private Location randomLocation() {
        Random random = new Random();
        return Location.values()[random.nextInt(Location.values().length)];
    }

    //Constructor


    public Table() {
        this.location = randomLocation();
        this.major = true;
    }

    public Table(int number, int numberOfSeats, boolean smoking) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
        this.smoking = smoking;
        this.location = randomLocation();
        this.major = true;
    }

    //Methods
    @Override
    public String Details() {
        String info, smoking = "Non Smoking";
        if (this.smoking)
            smoking = "Smoking";
        info =  "Number " + this.number + "\t" +
                this.numberOfSeats + " Seats\t" +
                smoking + "\t" + location.toString() + "\n";
        return info;
    }

    //Getters and Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
