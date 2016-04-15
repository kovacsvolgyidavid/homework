package xyz.codingmentor.training.restservice;

import xyz.codingmentor.training.services.AsynchronousCallService;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Kovácsvölgyi Dávid <kovacsvolgyi.david@gmail.com>
 */
@Path("/")
public class AsynchronusRESTService {

    @Inject
    private Logger logger;
    @Inject
    private AsynchronousCallService asyncService;

    @GET
    @Path("/mail")
    public Boolean sendMail() throws InterruptedException {

        Future<BigInteger> future = asyncService.asyncCall();

        while (!future.isDone()) {
            logger.info("I have the power");
            if (future.isCancelled()) {
                throw new IllegalStateException("I have been disrupted");
            }
        }
        try {
            logger.info(future.get().toString());
        } catch (ExecutionException ex) {
            logger.info(""+ex);
        }
        return true;
    }

}
