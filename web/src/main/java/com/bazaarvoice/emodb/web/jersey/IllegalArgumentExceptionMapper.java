package com.bazaarvoice.emodb.web.jersey;

import com.google.common.base.Objects;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-BV-Exception", IllegalArgumentException.class.getName())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(Objects.firstNonNull(e.getMessage(), "Invalid argument."))
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
