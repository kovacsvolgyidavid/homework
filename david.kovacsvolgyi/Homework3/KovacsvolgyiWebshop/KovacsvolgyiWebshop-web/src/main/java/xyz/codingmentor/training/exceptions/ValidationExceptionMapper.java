package xyz.codingmentor.training.exceptions;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    @Inject
    Logger logger;
    
    @Override
    public Response toResponse(ValidationException exception) {
        logger.severe(exception.getMessage());
        return Response.status(Status.BAD_REQUEST).entity(new ErrorDTO(exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }

}
