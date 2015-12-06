package com.nasa.service.impl;

import com.nasa.exception.BadRequestException;
import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Direction;
import com.nasa.model.enums.Rotation;
import com.nasa.model.repository.ExplorerRoutingRepository;
import com.nasa.service.ExplorerRoutingService;
import com.nasa.validator.ExplorerStepValidator;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingServiceImpl implements ExplorerRoutingService {
    private static final Logger logger = Logger.getLogger(ExplorerRoutingServiceImpl.class.getCanonicalName());

    private static final int STEP = 1;

    private final ExplorerStepValidator validator;
    private final ExplorerRoutingRepository repository;

    @Inject
    public ExplorerRoutingServiceImpl(final ExplorerStepValidator validator, final ExplorerRoutingRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    @Override
    public void rotate(final Rotation rotation) {
        if (rotation == null) {
            throw new BadRequestException("Rotation value cannot be null.");
        }
        final MarsExplorer mars = this.repository.findOne();
        mars.setDirection(Direction.rotate(mars.getDirection(), rotation));
        logger.info(String.format("MarsExplorer is rotating to '%s'", mars.getDirection()));
    }

    @Override
    public MarsExplorer getMarsExplorer() {
        final MarsExplorer mars = this.repository.findOne();
        logger.info(String.format("Getting: %s", mars.toString()));
        return mars;
    }

    @Override
    public void resetMarsExplorer() {
        this.repository.findOne().reset();
    }

    @Override
    public void move() {
        MarsExplorer mars = this.repository.findOne();
        Integer position = null;
        boolean moveAxisY = true;
        switch (mars.getDirection()) {
            case NORTH:
                position = mars.getAxisY() + STEP;
                break;
            case SOUTH:
                position = mars.getAxisY() - STEP;
                break;
            case EAST:
                position = mars.getAxisX() + STEP;
                moveAxisY = false;
                break;
            case WEST:
                position = mars.getAxisX() - STEP;
                moveAxisY = false;
                break;
        }
        logger.info(String.format("MarsExplorer is moving to position: '%s' on axis: '%s'", position, moveAxisY ? "Y" : "X"));
        this.validator.validatePosition(position);
        if (moveAxisY) {
            mars.setAxisY(position);
        } else {
            mars.setAxisX(position);
        }
    }
}
