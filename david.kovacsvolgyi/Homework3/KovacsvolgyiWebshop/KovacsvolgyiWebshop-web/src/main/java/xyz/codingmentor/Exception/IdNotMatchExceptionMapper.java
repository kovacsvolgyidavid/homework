package xyz.codingmentor.Exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Dénes László <denes.laszlo.88@gmail.com>
 */
@Provider
public class IdNotMatchExceptionMapper implements ExceptionMapper<IdNotMatchException> {

    @Override
    public Response toResponse(IdNotMatchException exception) {
        return Response.status(Status.BAD_REQUEST).entity(new ErrorDTO(exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }

}
