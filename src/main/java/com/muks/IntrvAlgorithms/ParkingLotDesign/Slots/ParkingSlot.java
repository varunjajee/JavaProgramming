package com.muks.IntrvAlgorithms.ParkingLotDesign.Slots;

/**
 * Created by mukthar.ahmed on 3/7/16.
 * - ParkingLot Object
 */
public class ParkingSlot {
    private int ID;
    private boolean isAvailable = true;

    private String dateTime;

    int tokenId;

    public ParkingSlot(int id) {
        this.ID = id;
    }

    public void occupy() {
        this.isAvailable = false;
    }

    public void release() {
        this.isAvailable = true;
    }

    public int getId() { return this.ID; }


    public boolean getAvailability() {
        return isAvailable;
    }

    public void setDateTime(String inDateTime) {
        this.dateTime = inDateTime;
    }

    public String getDateTime() { return dateTime; }

    public String toString() {
        return "[ID = " + ID + ", IsAvailable = " + isAvailable + "]";
    }
}
