package com.nasa.service.impl;

import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Direction;
import com.nasa.model.enums.Rotation;
import com.nasa.model.repository.ExplorerRoutingRepository;
import com.nasa.validator.ExplorerStepValidator;
import com.nasa.service.ExplorerRoutingService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingServiceImpl implements ExplorerRoutingService {
    private static final Logger logger = Logger.getLogger(ExplorerRoutingServiceImpl.class.getCanonicalName());

    private static final int STEP = 1;

    @Inject
    private ExplorerStepValidator validator;

    @Inject
    private ExplorerRoutingRepository repository;

    @Override
    public void rotate(final Rotation rotation) {
        final MarsExplorer mars = this.repository.findCurrentExplorer();
        mars.setDirection(Direction.rotate(mars.getDirection(), rotation));
    }

    @Override
    public MarsExplorer getMarsExplorer() {
        final MarsExplorer mars = this.repository.findCurrentExplorer();
        logger.info(String.format("Getting: %s", mars.toString()));
        return mars;
    }

    @Override
    public void resetMarsExplorer() {
        this.repository.findCurrentExplorer().reset();
    }

    @Override
    public void move() {
        MarsExplorer mars = this.repository.findCurrentExplorer();
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
        validator.validatePosition(position);
        if (moveAxisY) {
            mars.setAxisY(position);
        } else {
            mars.setAxisX(position);
        }
    }

    @Override
    public List<MarsExplorer> getAll() {
        return this.repository.findAll();
    }

    @Override
    public MarsExplorer save(final MarsExplorer marsExplorer) {
        return this.repository.save(marsExplorer);
    }
}
