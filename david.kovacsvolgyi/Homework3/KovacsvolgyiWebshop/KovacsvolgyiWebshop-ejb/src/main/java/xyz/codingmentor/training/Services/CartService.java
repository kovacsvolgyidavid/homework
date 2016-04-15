package xyz.codingmentor.training.Services;

import xyz.codingmentor.training.DTO.MobileDTO;
import xyz.codingmentor.training.DTO.UserDTO;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Stateful
public class CartService implements Serializable {

    @Inject
    private InventoryService inventory;
    @Inject
    private UserManagmentService userService;
    @Resource
    SessionContext context;

    //TODO: működés megvalósítása
    public MobileDTO addToCart(UserDTO user, MobileDTO mobile) {

        if (!inventory.isItAMobile(mobile)) {
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
