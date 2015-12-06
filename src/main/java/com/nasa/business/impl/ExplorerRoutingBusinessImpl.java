package com.nasa.business.impl;

import com.nasa.business.ExplorerRoutingBusiness;
import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Rotation;
import com.nasa.service.ExplorerRoutingService;
import com.nasa.validator.ExplorerStepValidator;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingBusinessImpl implements ExplorerRoutingBusiness {

    private final ExplorerRoutingService service;
    private final ExplorerStepValidator validator;

    @Inject
    public ExplorerRoutingBusinessImpl(final ExplorerRoutingService service, final ExplorerStepValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public MarsExplorer resetMarsExplorer() {
        this.service.resetMarsExplorer();
        return this.service.getMarsExplorer();
    }

    @Override
    public MarsExplorer getMarsExplorer() {
        return this.service.getMarsExplorer();
    }

    @Override
    public MarsExplorer move(final String command) {
        for (char step : this.validator.validateSteps(command)) {
            if (this.validator.isRotation(step)) {
                this.service.rotate(Rotation.getRotation(step));
            } else if (this.validator.isMove(step)) {
                this.service.move();
            }
        }
        return this.service.getMarsExplorer();
    }
}
