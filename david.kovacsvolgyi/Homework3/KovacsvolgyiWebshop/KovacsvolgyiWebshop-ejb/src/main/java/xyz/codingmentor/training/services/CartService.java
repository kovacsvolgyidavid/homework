package xyz.codingmentor.training.services;

import xyz.codingmentor.training.exceptions.CheckoutFailedException;
import xyz.codingmentor.training.dtos.MobileDTO;
import xyz.codingmentor.training.dtos.UserDTO;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;
import xyz.codingmentor.training.exceptions.SoldOutException;

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

        user.addCart(mobile);
        //userService.editUser(user.addCart(mobile), user);

        return mobile;

    }

    public List<MobileDTO> getCart(UserDTO user) {
        return user.getCart();
    }

    public Integer checkout(UserDTO user) {
        Integer fullPrice = 0;
        try{
        fullPrice = user.getCart().stream().map((mobile) -> inventory.buyMobile(mobile)).reduce(fullPrice, Integer::sum);}
        catch(SoldOutException sex){
            user.deleteCart();
            throw new CheckoutFailedException("Checkout failed: user's cart has been deleted");
        
        }
        user.deleteCart();

        return fullPrice;

    }
}
