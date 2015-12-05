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
public class BadRequestExceptionHandler implements ExceptionMapper<BadRequestException> {
    private static final String ERROR_CODE = "BadRequest";

    @Override
    public Response toResponse(BadRequestException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResource(ERROR_CODE, exception.getMessage()))
                .build();
    }
}
