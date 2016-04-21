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
import xyz.codingmentor.training.exceptions.CheckoutFailedException;

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
        for (MobileDTO mobile : user.getCart()) {
            if (mobile.getPiece() < 1) {
                user.deleteCart();
                throw new CheckoutFailedException("We don't have enough from" + mobile.getManufacturer() + mobile.getType());
            }
        }
        fullPrice = user.getCart().stream().map(mobile
                -> inventory.buyMobile(mobile)).reduce(fullPrice, Integer::sum);
        user.deleteCart();
        return fullPrice;
    }
}
