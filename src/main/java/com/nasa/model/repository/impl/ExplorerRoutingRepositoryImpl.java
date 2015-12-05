package com.nasa.model.repository.impl;

import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.repository.ExplorerRoutingRepository;

import javax.inject.Named;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingRepositoryImpl implements ExplorerRoutingRepository {

    private static final MarsExplorer MARS_EXPLORER = MarsExplorer.getInstance();

    @Override
    public MarsExplorer findOne() {
        return MARS_EXPLORER;
    }
}
