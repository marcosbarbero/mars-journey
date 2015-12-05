package com.nasa.business.impl;

import com.nasa.business.ExplorerRoutingBusiness;
import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Rotation;
import com.nasa.validator.ExplorerStepValidator;
import com.nasa.service.ExplorerRoutingService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingBusinessImpl implements ExplorerRoutingBusiness {

    @Inject
    private ExplorerRoutingService service;

    @Inject
    private ExplorerStepValidator validator;

    @Override
    public MarsExplorer resetMarsExplorer() {
        this.service.resetMarsExplorer();
        final MarsExplorer marsExplorer = this.service.getMarsExplorer();
        this.service.save(marsExplorer);
        return marsExplorer;
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
        final MarsExplorer marsExplorer = this.service.getMarsExplorer();
        this.service.save(marsExplorer);
        return marsExplorer;
    }

    @Override
    public List<MarsExplorer> trace() {
        return this.service.getAll();
    }
}
