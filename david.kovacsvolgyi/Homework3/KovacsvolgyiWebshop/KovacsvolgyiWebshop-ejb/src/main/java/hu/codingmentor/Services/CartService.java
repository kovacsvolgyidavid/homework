/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.Services;

import hu.codingmentor.DTO.MobileDTO;
import hu.codingmentor.DTO.UserDTO;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author keni
 */
@Stateful
public class CartService {
    
    private InventoryService inventory;
    private UserManagmentService userService;
    @Resource
    SessionContext context;
  
    //TODO: működés megvalósítása
   public UserDTO addToCart(HttpServletRequest request,MobileDTO mobile){
       HttpSession session = request.getSession();
        Object userObject=request.getAttribute("user");
        if(userObject!=null&&userObject instanceof UserDTO){
            UserDTO newUser=(UserDTO) userObject;
            UserDTO oldUser=userService.getUser(newUser.getUsername());
            newUser.getCart().add(mobile);
           return userService.editUser(newUser, oldUser);
            
            
        }
        throw new IllegalArgumentException("Error in session, not a valid username, or just please login :)");
    
    }
   

    public Integer checkout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userObject=request.getAttribute("user");
        Integer fullPrice=0;
        if(userObject!=null&&userObject instanceof UserDTO){
            UserDTO user=(UserDTO) userObject;
            
            fullPrice = user.getCart().stream().map((mobile) -> inventory.buyMobile(mobile)).reduce(fullPrice, Integer::sum);
           user.deleteCart();
            return fullPrice;
        }else{
         throw new IllegalArgumentException("Bad user object");   
        }
        
        
    }
}
