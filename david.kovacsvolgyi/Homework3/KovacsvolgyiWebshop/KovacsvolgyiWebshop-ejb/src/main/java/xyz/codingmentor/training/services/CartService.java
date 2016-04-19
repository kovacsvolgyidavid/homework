package xyz.codingmentor.training.services;

import xyz.codingmentor.training.dtos.MobileDTO;
import xyz.codingmentor.training.dtos.UserDTO;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
public class CartService implements Serializable {

    @Inject
    private transient InventoryService inventory;
    @Inject
    private transient UserManagmentService userService;

    public MobileDTO addToCart(UserDTO user, MobileDTO mobile) {
        user.addCart(mobile);
        return mobile;
    }

    public List<MobileDTO> getCart(UserDTO user) {
        return user.getCart();
    }

    public Integer checkout(UserDTO user) {
        Integer fullPrice = 0;
        try {
            fullPrice = user.getCart().stream().map(mobile
                    -> inventory.buyMobile(mobile)).reduce(fullPrice, Integer::sum);
        } catch (SoldOutException sex) {
            user.deleteCart();
            throw sex;
        }
        user.deleteCart();
        return fullPrice;
    }
}
