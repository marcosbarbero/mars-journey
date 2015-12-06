package com.nasa.web.resources;

import com.nasa.business.ExplorerRoutingBusiness;
import com.nasa.model.beans.MarsExplorer;

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

    private ExplorerRoutingBusiness business;

    @Inject
    public void setBusiness(ExplorerRoutingBusiness business) {
        this.business = business;
    }

    /**
     * Return the current MarsExplorer.
     *
     * @return The current MarsExplorer
     */
    @GET
    public Response getMarsExplorer() {
        return Response.ok(this.business.getMarsExplorer()).build();
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
        return Response.ok(this.business.move(command)).build();
    }

    /**
     * Reset the current MarsExplorer to initial position.
     *
     * @return Response status OK (200).
     */
    @POST
    @Path("/reset")
    public Response resetMarsExplorer() {
        logger.info("Just reset the MarsExplorer to initial position.");
        return Response.ok(this.business.resetMarsExplorer()).build();
    }
}
