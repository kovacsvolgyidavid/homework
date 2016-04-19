package xyz.codingmentor.training.restservice;

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
import java.util.List;
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
@SessionScoped
public class CartRESTService implements Serializable {

    @Inject
    private CartService cart;
    @Inject
    private transient InventoryService inventory;
    private static final String USER_ATRIBUTE="user";

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public MobileDTO addToCart(@Context HttpServletRequest request, MobileDTO mobile) {
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute(USER_ATRIBUTE);
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
    @Path("/")
    @Produces("application/json")
    public List<MobileDTO> getCart(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute(USER_ATRIBUTE);
        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;
            return cart.getCart(user);
        } else {
            throw new IllegalArgumentException("Please log in");
        }
    }

    @GET
    @Path("/checkout")
    @Produces("application/json")
    public String checkout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute(USER_ATRIBUTE);
        UserDTO user;
        if (userObject != null && userObject instanceof UserDTO) {
            user = (UserDTO) userObject;
            return cart.checkout(user).toString();
        } else {
            throw new IllegalArgumentException("Please login");
        }
    }
}