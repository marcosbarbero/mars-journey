package com.nasa.model.service.impl;

import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Direction;
import com.nasa.model.enums.Rotation;
import com.nasa.model.service.ExplorerRoutingService;
import com.nasa.model.validator.ExplorerStepValidator;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingServiceImpl implements ExplorerRoutingService {
    private static final MarsExplorer MARS_EXPLORER = MarsExplorer.getInstance();
    private static final int STEP = 1;

    @Inject
    private ExplorerStepValidator validator;

    private void rotate(Rotation rotation) {
        MARS_EXPLORER.setDirection(Direction.rotate(MARS_EXPLORER.getDirection(), rotation));
    }

    /**
     * Move the ${@link MarsExplorer} to requested position.
     */
    private void move() {
        Integer position = null;
        boolean moveAxisY = true;
        switch (MARS_EXPLORER.getDirection()) {
            case NORTH:
                position = MARS_EXPLORER.getAxisY() + STEP;
                break;
            case SOUTH:
                position = MARS_EXPLORER.getAxisY() - STEP;
                break;
            case EAST:
                position = MARS_EXPLORER.getAxisX() + STEP;
                moveAxisY = false;
                break;
            case WEST:
                position = MARS_EXPLORER.getAxisX() - STEP;
                moveAxisY = false;
                break;
        }
        validator.validatePosition(position);
        if (moveAxisY) {
            MARS_EXPLORER.setAxisY(position);
        } else {
            MARS_EXPLORER.setAxisX(position);
        }
    }

    @Override
    public MarsExplorer getMarsExplorer() {
        return MARS_EXPLORER;
    }

    @Override
    public void resetMarsExplorer() {
        MARS_EXPLORER.reset();
    }

    @Override
    public MarsExplorer move(final String command) {
        for (char step : this.validator.validateSteps(command)) {
            if (this.validator.isRotation(step)) {
                this.rotate(Rotation.getRotation(step));
            } else if (this.validator.isMove(step)) {
                this.move();
            }
        }
        return MARS_EXPLORER;
    }

}
