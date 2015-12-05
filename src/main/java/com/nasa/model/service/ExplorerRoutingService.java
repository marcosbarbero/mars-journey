package com.nasa.model.service;

import com.nasa.model.beans.MarsExplorer;

/**
 * Service layer of ${@link com.nasa.model.beans.MarsExplorer} routing.
 *
 * @author marcos.barbero
 */
public interface ExplorerRoutingService {

    /**
     * Return the current ${@link com.nasa.model.beans.MarsExplorer}.
     *
     * @return The ${@link com.nasa.model.beans.MarsExplorer}
     */
    MarsExplorer getMarsExplorer();

    /**
     * Reset the current ${@link com.nasa.model.beans.MarsExplorer} to initial position.
     */
    void resetMarsExplorer();

    /**
     * Move the ${@link com.nasa.model.beans.MarsExplorer} with given command.
     *
     * @param command The command
     * @return The ${@link com.nasa.model.beans.MarsExplorer}
     */
    MarsExplorer move(final String command);
}
