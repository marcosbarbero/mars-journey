package com.nasa.model.beans;

import com.nasa.model.enums.Direction;

import java.io.Serializable;

/**
 * Simple singleton class that represents the Mars Explorer.
 *
 * @author marcos.barbero
 */
public class MarsExplorer implements Serializable {
    private static final long serialVersionUID = -340875071855645838L;
    private static MarsExplorer instance;

    private int axisX;
    private int axisY;
    private Direction direction;

    /**
     * Private construct with mars startup value.
     */
    private MarsExplorer() {
        this.reset();
    }

    public static synchronized MarsExplorer getInstance() {
        if (instance == null) {
            instance = new MarsExplorer();
        }
        return instance;
    }

    @Override
    public String toString() {
        return String.format("MarsExplorer: {'axisX': %s, 'axisY': %s, 'direction': %s}", this.axisX, this.axisY, this.direction.name());
    }

    /**
     * Reset the current object with initial values.
     */
    public void reset() {
        this.axisX = 0;
        this.axisY = 0;
        this.direction = Direction.NORTH;
    }

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
