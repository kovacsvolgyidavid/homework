/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.RESTServices;

import hu.codingmentor.DTO.UserDTO;
import hu.codingmentor.Services.UserManagmentService;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

/**
 *
 * @author keni
 */
@Path("/user")
public class UserRESTService {

    @EJB
    UserManagmentService userManager;

    @GET
    @Path("/")
    public List<UserDTO> getUsers(@Context HttpServletRequest request, @PathParam("username") String username) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        if (user.isAdmin()) {

            return userManager.getUsers();
        } else {
            throw new IllegalArgumentException("You are not an admin");
        }
    }

    @GET
    @Path("/{username}")
    public UserDTO getUser(@Context HttpServletRequest request, @PathParam("username") String username) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        if (user.isAdmin()) {

            return userManager.getUser(username);
        } else {
            throw new IllegalArgumentException("You are not an admin");
        }

    }
   @DELETE
    @Path("/{username}")
    public UserDTO deleteUser(@Context HttpServletRequest request, @PathParam("username") String username) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        if (user.isAdmin()) {

            return userManager.removeUser(userManager.getUser(username));
        } else {
            throw new IllegalArgumentException("You are not an admin");
        }

    }
    @POST
    @Path("/")
    @Consumes("application/json")
    public UserDTO addUser(@Context HttpServletRequest request, UserDTO addedUser) {

        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        if (user.isAdmin()) {
            return userManager.addUser(addedUser);
        } else {
            throw new IllegalArgumentException("You are not an admin");
        }

    }
    
    @PUT
    @Path("/{username}")
    @Consumes("application/json")
    
    public UserDTO editUser(@Context HttpServletRequest request, @PathParam("username")String oldUsername,UserDTO newUser) {
        
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");

        UserDTO user;
        if (userObject instanceof UserDTO && userObject != null) {
            user = (UserDTO) userObject;

        } else {
            throw new IllegalArgumentException("Please log in");
        }
        if (user.isAdmin()) {
            
            return userManager.editUser(newUser,userManager.getUser(oldUsername));
        } else {
            throw new IllegalArgumentException("You are not an admin");
        }

    }

    @POST
    @Consumes("application/json")
    @Path("/login")
    public boolean login(@Context HttpServletRequest request, UserDTO userJ) {
        HttpSession session = request.getSession(true);

        UserDTO user = userManager.getUser(userJ.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("No such username");
        }
        if (user.getPassword().equals(userJ.getPassword())) {
            session.setMaxInactiveInterval(20000);
            session.setAttribute("user", user);

            return true;
        } else {
            session.invalidate();
            throw new IllegalArgumentException("wrong password");
        }

    }
    @Path("/logout")
    @POST
    @Consumes("aplication/json")
    public boolean logout(@Context HttpServletRequest request){
        HttpSession session = request.getSession();
        Object objectUser=session.getAttribute("user");
        
        if(objectUser!=null&&objectUser instanceof UserDTO){
        session.invalidate();
        return true;
        }
    throw new IllegalArgumentException("First login to logout");
    }

}
