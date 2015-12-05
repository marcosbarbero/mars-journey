package com.nasa.business;

import com.nasa.model.beans.MarsExplorer;

import java.util.List;

/**
 * Business rules layer.
 *
 * @author marcos.barbero
 */
public interface ExplorerRoutingBusiness {

    /**
     * Reset the ${@link MarsExplorer}.
     *
     * @return The ${@link MarsExplorer} with initial value.
     */
    MarsExplorer resetMarsExplorer();

    /**
     * Return the current ${@link MarsExplorer}.
     *
     * @return The current ${@link MarsExplorer}
     */
    MarsExplorer getMarsExplorer();

    /**
     * Move the ${@link MarsExplorer} using the given command.
     *
     * @param command The command
     * @return Moved ${@link MarsExplorer}
     */
    MarsExplorer move(final String command);

    /**
     * Return a list of all moves of ${@link MarsExplorer}.
     *
     * @return A trace of all ${@link MarsExplorer} moves
     */
    List<MarsExplorer> trace();
}
