package com.nasa.web.provider;

import com.nasa.exception.BadRequestException;
import com.nasa.model.beans.ErrorResource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Provider to handle my ${@link com.nasa.exception.BadRequestException}.
 *
 * @author marcos.barbero
 */
@Provider
public class ExceptionHttpStatusResolver implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResource("BadRequest", exception.getMessage()))
                .build();
    }
}
