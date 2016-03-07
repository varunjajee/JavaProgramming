package com.muks.IntrvAlgorithms.ParkingLotDesign.Slots;

import com.muks.IntrvAlgorithms.ParkingLotDesign.Slots.ParkingSlot;

/**
 * Created by mukthar.ahmed on 3/7/16.
 */
public class PremiumSlot extends ParkingSlot {
    public PremiumSlot(int id) {
        super(id);
    }

    String type = "premium";

    public String toString() {
        return "[ID = " + getId() + ", isOccupied = " + getAvailability() + ", Type = " + type + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.getId();
        return hash;
    }
}
