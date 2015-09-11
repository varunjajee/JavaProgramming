package com.muks.javaex.enumex;

/**
 * Created by mukthar.ahmed on 22/04/15.
 */
public enum IntReturnEnum {
    DRAFT(1),
    PUBLISHED(2),
    ACTIVATED(3),
    PAUSED(4),
    EXPIRED(5),
    PENDING(6),
    REJECTED(7),
    INMOBI_PAUSED(8),
    ARCHIVED(9),
    ONHOLD(10);

    private int col;
    IntReturnEnum(int col) {
        this.col=col;
    }

    public static IntReturnEnum findByValue(int statusValue) {
        for (IntReturnEnum mapping : IntReturnEnum.values()) {
            System.out.println("+ COL: " + mapping);

            if (mapping.col == statusValue) {
                System.out.println("+ " + mapping.col + " == + " + statusValue);
                return mapping;
            }
        }
        return null;
    }   //

}   // end class()
