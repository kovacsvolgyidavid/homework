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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 *
 * @author keni
 */
@Path("/mobiles")
public class InventoryRESTService {
    InventoryService inventory;
    @POST
    @Path("/")
    @Consumes("application/json")
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
    @Consumes("application/json")
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
