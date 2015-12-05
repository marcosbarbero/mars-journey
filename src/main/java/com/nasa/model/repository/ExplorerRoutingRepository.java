package com.nasa.model.repository;

import com.nasa.model.beans.MarsExplorer;

import java.util.List;

/**
 * InMemory repository of ${@link com.nasa.model.beans.MarsExplorer}.
 *
 * @author marcos.barbero
 */
public interface ExplorerRoutingRepository {

    /**
     * Return the current ${@link MarsExplorer} in use.
     *
     * @return The ${@link MarsExplorer}
     */
    MarsExplorer findCurrentExplorer();

    /**
     * Return a collection of ${@link MarsExplorer}.
     *
     * @return Collection of ${@link MarsExplorer}
     */
    List<MarsExplorer> findAll();

    /**
     * Persists a new ${@link MarsExplorer}.
     *
     * @param marsExplorer The ${@link MarsExplorer} to be persisted
     * @return The persisted ${@link MarsExplorer}
     */
    MarsExplorer save(final MarsExplorer marsExplorer);
}
