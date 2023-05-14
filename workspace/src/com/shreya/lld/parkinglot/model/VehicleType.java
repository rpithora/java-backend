package com.shreya.lld.parkinglot.model;

public enum VehicleType {
    TWO_WHEELER, FOUR_WHEELER, UNKNOWN;

    public static VehicleType fromString(final String type) {
        try {
            return valueOf(type.toUpperCase());
        } catch (java.lang.IllegalArgumentException ex) {
            System.out.println("No a Valid VehicleType [TWO_WHEELER, FOUR_WHEELER]. Returning UNKNOWN." + type);
            return UNKNOWN;
        }
    }
}
