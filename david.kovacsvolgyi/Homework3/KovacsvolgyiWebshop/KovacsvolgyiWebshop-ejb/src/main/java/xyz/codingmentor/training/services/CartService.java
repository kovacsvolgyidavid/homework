package xyz.codingmentor.training.services;

import xyz.codingmentor.training.dtos.MobileDTO;
import xyz.codingmentor.training.dtos.UserDTO;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Stateful
@StatefulTimeout(value = 500, unit = TimeUnit.SECONDS)
@LocalBean
public class CartService implements Serializable {

    @Inject
    private InventoryService inventory;
    @Inject
    private UserManagmentService userService;
    @Resource
    SessionContext context;

    //TODO: működés megvalósítása
    public MobileDTO addToCart(UserDTO user, MobileDTO mobile) {

      
      
       userService.editUser(user.addCart(mobile), user);
        
        return mobile;

    }

    public Integer checkout(UserDTO user) {//TODO itt jártam
        Integer fullPrice = 0;
        fullPrice = user.getCart().stream().map((mobile) -> inventory.buyMobile(mobile)).reduce(fullPrice, Integer::sum);
        user.deleteCart();
        return fullPrice;

    }
}
