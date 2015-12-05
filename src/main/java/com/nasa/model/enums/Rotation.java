package com.nasa.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum with valid rotation values.
 *
 * @author marcos.barbero
 */
public enum Rotation {
    LEFT('L', -90), RIGHT('R', 90);

    private char rotation;
    private int value;

    private static final Map<Character, Rotation> lookup = new HashMap<>();

    static {
        for (Rotation rotation : Rotation.values()) {
            lookup.put(rotation.getRotation(), rotation);
        }
    }

    Rotation(char rotation, int value) {
        this.value = value;
        this.rotation = rotation;
    }

    public int getValue() {
        return this.value;
    }

    public char getRotation() {
        return this.rotation;
    }

    public static Rotation getRotation(final char rotation) {
        return lookup.get(rotation);
    }
}
