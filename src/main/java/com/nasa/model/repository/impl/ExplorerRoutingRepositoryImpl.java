package com.nasa.model.repository.impl;

import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.repository.ExplorerRoutingRepository;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerRoutingRepositoryImpl implements ExplorerRoutingRepository {

    private static final MarsExplorer MARS_EXPLORER = MarsExplorer.getInstance();

    // In memory repository
    private static final List<MarsExplorer> EXPLORERS = new ArrayList<>();

    @PostConstruct
    public void setup() {
        this.save(MARS_EXPLORER);
    }

    @Override
    public MarsExplorer findCurrentExplorer() {
        return MARS_EXPLORER;
    }

    @Override
    public List<MarsExplorer> findAll() {
        return EXPLORERS;
    }

    @Override
    public MarsExplorer save(final MarsExplorer marsExplorer) {
        EXPLORERS.add(marsExplorer);
        return marsExplorer;
    }
}
