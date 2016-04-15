package xyz.codingmentor.training.RESTServices;

import xyz.codingmentor.training.DTO.MobileDTO;
import xyz.codingmentor.training.DTO.UserDTO;
import xyz.codingmentor.training.Services.CartService;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import xyz.codingmentor.training.interceptor.ValidatorInterceptor;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Path("/cart")
@Interceptors(ValidatorInterceptor.class)
@SessionScoped
public class CartRESTService implements Serializable {

    @EJB
    private CartService cart;

    @POST
    @Path("/")
    @Consumes("application/json")
    public Object addToCart(@Context HttpServletRequest request, MobileDTO mobile) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;
            return cart.addToCart(user, mobile);
        } else {
            throw new IllegalArgumentException("Please log in");
        }

    }

    @GET
    @Path("/")
    public Integer checkout(@Context HttpServletRequest request) {//TODO valami itt nem jó
        HttpSession session = request.getSession();
        Object userObject = request.getAttribute("user");

        if (userObject != null && userObject instanceof UserDTO) {
            UserDTO user = (UserDTO) userObject;

            return cart.checkout(user);
        } else {
            throw new IllegalArgumentException("Please login");
        }

    }
}
