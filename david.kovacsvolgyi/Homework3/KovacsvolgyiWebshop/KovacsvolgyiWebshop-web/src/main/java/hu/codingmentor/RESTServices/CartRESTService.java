/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.RESTServices;

import hu.codingmentor.DTO.MobileDTO;
import hu.codingmentor.Services.CartService;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 *
 * @author keni
 */
@Path("/cart")
public class CartRESTService {
    
     @EJB
    private CartService cart;
    
    @POST
    @Path("/")
    @Consumes("application/json")
    public MobileDTO addProduct(@Context HttpServletRequest request,MobileDTO mobil) {
       
           cart.addToCart(request,mobil);
        
        
        
       return mobil;
   
    }
    @GET
    @Path("/")
public Integer checkout(@Context HttpServletRequest request){
    return cart.checkout(request);

}    
}