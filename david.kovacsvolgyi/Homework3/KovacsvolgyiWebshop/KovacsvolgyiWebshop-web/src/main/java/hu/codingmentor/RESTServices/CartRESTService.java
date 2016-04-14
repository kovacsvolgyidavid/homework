/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.RESTServices;

import hu.codingmentor.DTO.MobileDTO;
import hu.codingmentor.DTO.UserDTO;
import hu.codingmentor.Services.CartService;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import hu.codingmentor.training.interceptor.ValidatorInterceptor;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
