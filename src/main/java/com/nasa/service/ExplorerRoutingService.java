package com.nasa.service;

import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Rotation;

/**
 * Service layer of ${@link com.nasa.model.beans.MarsExplorer} routing.
 *
 * @author marcos.barbero
 */
public interface ExplorerRoutingService {

    /**
     * Rotate the ${@link MarsExplorer}.
     *
     * @param rotation ${@link Rotation}
     */
    void rotate(final Rotation rotation);

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
     * Move the ${@link com.nasa.model.beans.MarsExplorer}.
     */
    void move();
}
