package com.nasa.web.resources;

import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.service.ExplorerRoutingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * This resource will route the Mars explorer.
 *
 * @author marcos.barbero
 */
@Path("/mars")
@Produces(APPLICATION_JSON)
public class ExplorerRoutingResource {
    public static final Logger logger = Logger.getLogger(ExplorerRoutingResource.class.getCanonicalName());

    @Inject
    private ExplorerRoutingService routingService;

    /**
     * Return ${@link MarsExplorer}.
     *
     * @return The ${@link MarsExplorer}
     */
    private MarsExplorer marsExplorer() {
        final MarsExplorer marsExplorer = this.routingService.getMarsExplorer();
        logger.info("Getting the current MarsExplorer position: " + marsExplorer.toString());
        return marsExplorer;
    }

    /**
     * Return the current MarsExplorer.
     *
     * @return The current MarsExplorer
     */
    @GET
    public Response getMarsExplorer() {
        return Response.ok(marsExplorer()).build();
    }

    /**
     * Reset the current MarsExplorer to initial position.
     *
     * @return Response status OK (200).
     */
    @POST
    public Response resetMarsExplorer() {
        logger.info("Just reset the MarsExplorer to initial position.");
        this.routingService.resetMarsExplorer();
        return Response.ok(marsExplorer()).build();
    }

    /**
     * Move the ${@link MarsExplorer} with given command.
     *
     * @param command the command
     * @return Moved ${@link MarsExplorer}
     */
    @GET
    @Path("{command}")
    public Response move(@PathParam("command") String command) {
        return Response.ok(this.routingService.move(command)).build();
    }
}
