package com.muks.IntrvAlgorithms.ParkingLotDesign;

import com.muks.IntrvAlgorithms.ParkingLotDesign.Slots.HandicappedSlot;
import com.muks.IntrvAlgorithms.ParkingLotDesign.Slots.NormalSlot;
import com.muks.IntrvAlgorithms.ParkingLotDesign.Slots.ParkingSlot;
import com.muks.IntrvAlgorithms.ParkingLotDesign.Slots.PremiumSlot;

/**
 * Created by mukthar.ahmed on 3/7/16.
 * - Parking space object
 */
public class ParkingSpace {
    static ParkingSlot[] slots = new ParkingSlot[4];

    public ParkingSpace() {
        slots[0] = new HandicappedSlot(1);
        slots[1] = new PremiumSlot(2);
        slots[2] = new NormalSlot(3);
        slots[3] = new NormalSlot(4);
    }


    public void doPark(String type) {
        ParkingSlot slot;
        if ( (slot = getSlot(type)) != null ) {
            slot.setDateTime(DateUtils.getDateTime());
            System.out.println("\n+ Parking available, a parking ticket should be allocated here!!!");
        }
        else {
            System.out.println("+ Sorry! - There's NO slot available, you cannot park at the moment.");
        }
    }

    public ParkingSlot getSlot(String type) {
        return slotAvailable(type);
    }

    private ParkingSlot slotAvailable(String type) {

        if (type.equalsIgnoreCase("normal")) {
            for (int i = 2; i <= 3; i++) {
                if (slots[i].getAvailability()) {
                    return slots[i];
                }
            }
        }
        else if (type.equalsIgnoreCase("handicapped")) {
            if (slots[0].getAvailability()) {
                return slots[0];
            }
        }
        else {
            if (slots[1].getAvailability()) {
                return slots[1];
            }
        }

        return null;
    }


}
