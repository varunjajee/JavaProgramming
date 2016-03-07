package com.muks.IntrvAlgorithms.ParkingLotDesign.Slots;

import com.muks.IntrvAlgorithms.ParkingLotDesign.Slots.ParkingSlot;

/**
 * Created by mukthar.ahmed on 3/7/16.
 */
public class HandicappedSlot extends ParkingSlot {
    public HandicappedSlot(int id) {
        super(id);
    }

    String type = "handicapped";

    public String toString() {
        return "[ID = " + getId() + ", isOccupied = " + getAvailability() + ", Type = " + type + "]";
    }
}
