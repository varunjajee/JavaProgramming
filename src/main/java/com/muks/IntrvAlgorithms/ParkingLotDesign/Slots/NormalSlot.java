package com.muks.IntrvAlgorithms.ParkingLotDesign.Slots;

/**
 * Created by mukthar.ahmed on 3/7/16.
 */
public class NormalSlot extends ParkingSlot {
    public NormalSlot(int id) {
        super(id);
    }

    String type = "normal";

    public String toString() {
        return "[ID = " + getId() + ", isOccupied = " + getAvailability() + ", Type = " + type + "]";
    }
}
