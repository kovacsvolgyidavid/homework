/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.RESTServices;

import hu.codingmentor.DTO.MobileDTO;
import hu.codingmentor.DTO.UserDTO;
import hu.codingmentor.Services.InventoryService;
import java.util.List;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import hu.codingmentor.training.interceptor.ValidatorInterceptor;
import javax.ejb.EJB;
import javax.interceptor.ExcludeClassInterceptors;
import javax.ws.rs.Produces;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Path("/mobiles")
@Interceptors(ValidatorInterceptor.class)
public class InventoryRESTService {
    @EJB
    InventoryService inventory;

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    @ExcludeClassInterceptors
    public MobileDTO addMobile(@Context HttpServletRequest request, MobileDTO mobile) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        if (user.isAdmin()) {
            return inventory.addMobile(mobile);
        } else {
            throw new IllegalArgumentException("You are not an admin");
        }

    }

    @GET
    @Path("/")
    public List<MobileDTO> getMobiles(@Context HttpServletRequest request) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        return inventory.getMobilesList();

    }
}
