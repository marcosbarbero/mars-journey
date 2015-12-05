package com.nasa.model.repository;

import com.nasa.model.beans.MarsExplorer;

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
    MarsExplorer findOne();

}
