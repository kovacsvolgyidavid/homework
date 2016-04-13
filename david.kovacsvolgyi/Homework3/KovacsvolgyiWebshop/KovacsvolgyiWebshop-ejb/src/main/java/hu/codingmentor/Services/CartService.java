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

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Stateful
public class CartService {

    private InventoryService inventory;
    private UserManagmentService userService;
    @Resource
    SessionContext context;

    //TODO: működés megvalósítása
    public MobileDTO addToCart(UserDTO user, MobileDTO mobile) {
        if(!inventory.isItAMobile(mobile)){
        throw new IllegalArgumentException("We don't have this mobile in our store.");
    }
        UserDTO listedUser = userService.getUser(user);
        listedUser.getCart().add(mobile);
        return mobile;

    }

    public Integer checkout(UserDTO user) {//TODO itt jártam
        Integer fullPrice = 0;
        fullPrice = user.getCart().stream().map((mobile) -> inventory.buyMobile(mobile)).reduce(fullPrice, Integer::sum);
        user.deleteCart();
        return fullPrice;

    }
}
