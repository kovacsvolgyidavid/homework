package xyz.codingmentor.training.RESTServices;

import xyz.codingmentor.training.dtos.MobileDTO;
import xyz.codingmentor.training.dtos.UserDTO;
import xyz.codingmentor.training.services.CartService;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import xyz.codingmentor.training.interceptor.ValidatorInterceptor;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Produces;
import xyz.codingmentor.training.services.InventoryService;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Path("/cart")
@Interceptors(ValidatorInterceptor.class)
public class CartRESTService implements Serializable {

    @Inject
    @SessionScoped
    private CartService cart;
    @Inject
    private InventoryService inventory;
    @Inject
    private Logger logger;
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")

    public MobileDTO addToCart(@Context HttpServletRequest request, MobileDTO mobile) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            if (!inventory.isItAMobile(mobile)) {
                throw new IllegalArgumentException("We don't have this mobile in our store.");
            }
            user = (UserDTO) userObject;
            return cart.addToCart(user, mobile);
        } else {
            throw new IllegalArgumentException("Please log in");
        }

    }

    @GET
    @Path("/checkout")
    
    @Produces("application/Text")
    public Integer checkout(@Context HttpServletRequest request) {//TODO valami itt nem jó
        HttpSession session = request.getSession();
        Object userObject = request.getAttribute("user");
        logger.info(userObject.toString());
        UserDTO user;
        if (userObject != null && userObject instanceof UserDTO) {
            user = (UserDTO) userObject;

            return cart.checkout(user);
        } else {
            throw new IllegalArgumentException("Please login");
        }

    }
}
