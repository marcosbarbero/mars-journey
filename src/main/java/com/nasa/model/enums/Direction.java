package com.nasa.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum with directions with {@link com.nasa.model.beans.MarsExplorer} allowed directions.
 *
 * @author marcos.barbero
 */
public enum Direction {

    NORTH("N", 0), SOUTH("S", 180), EAST("E", 90), WEST("W", 270);

    private String position;
    private int value;
    private static final Map<Integer, Direction> lookup = new HashMap<>();

    static {
        for (Direction direction : Direction.values()) {
            lookup.put(direction.getValue(), direction);
        }
    }

    Direction(final String position, final int value) {
        this.position = position;
        this.value = value;
    }

    public String getPosition() {
        return this.position;
    }

    public int getValue() {
        return this.value;
    }

    private static Direction getDirection(Direction direction, Rotation rotation) {
        Direction result;
        final int value = direction.getValue() + rotation.getValue();
        if (value < NORTH.getValue()) {
            result = WEST;
        } else if (value > WEST.getValue()) {
            result = NORTH;
        } else {
            result = lookup.get(value);
        }
        return result;
    }

    public static Direction rotate(Direction direction, Rotation rotation) {
        return getDirection(direction, rotation);
    }
}
