package com.epam.training.task1.model.entity.carriage.passenger;

/**
 * Comfort is the enum-class which has types of comfort of passenger carriages. Each enum-field has level of comfort -
 * integer number.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

public enum Comfort {
    //increase sequence of types of comforts. (number) - level of comfort
    SEAT(0), COMMON(1), RESERVED_SEAT(2), COMPARTMENT(3), SUITE(4);

    //field - level of comfort
    private final int levelOfComfort;

    //constructor with level of comfort
    Comfort(int levelOfComfort){
        this.levelOfComfort = levelOfComfort;
    }

    //get level of comfort
    public int getLevelOfComfort() {
        return levelOfComfort;
    }
}
