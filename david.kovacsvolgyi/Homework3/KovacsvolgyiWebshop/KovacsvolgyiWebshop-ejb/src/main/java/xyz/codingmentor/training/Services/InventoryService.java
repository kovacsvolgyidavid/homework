package xyz.codingmentor.training.Services;

import xyz.codingmentor.training.DTO.MobileDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import xyz.codingmentor.training.exceptions.SoldOutException;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Singleton
@Startup
public class InventoryService {

    private final Set<MobileDTO> mobiles = new HashSet<>();

    @PostConstruct
    private void addMobileOnStart() {
        mobiles.add(new MobileDTO(UUID.randomUUID().toString(), "3610", "Nokia", 50, 3));
        mobiles.add(new MobileDTO(UUID.randomUUID().toString(), "Lumia45", "Nokia", 500, 12));
        mobiles.add(new MobileDTO(UUID.randomUUID().toString(), "XperiaZ4", "Sony", 1, 5));
        mobiles.add(new MobileDTO(UUID.randomUUID().toString(), "10s", "iPhone", 99999999, 0));

    }

    public MobileDTO addMobile(MobileDTO mobil) {

        if (mobiles.contains(mobil)) {
            throw new IllegalArgumentException("We have this mobile already in store");
        }
        mobil.setId(UUID.randomUUID().toString());
        mobiles.add(mobil);
        return mobil;
    }

    public Integer buyMobile(MobileDTO mobil) {
        if (!mobiles.contains(mobil)) {
            throw new IllegalArgumentException("we don't have this kind of mobile");
        }
        if (mobil.getPiece() <= 0) {
            throw new SoldOutException("We don't have any of this mobile on stock :(");
        }
        mobiles.remove(mobil);
        MobileDTO mobilBuffer = mobil;
        mobilBuffer.setPiece(mobilBuffer.getPiece() - 1);
        mobiles.add(mobilBuffer);
        return mobilBuffer.getPrice();

    }

    public List<MobileDTO> getMobilesList() {
        List<MobileDTO> mobileList = new ArrayList<>();
        mobileList.addAll(mobiles);
        return mobileList;
    }

    public boolean isItAMobile(MobileDTO mobile) {
        return mobiles.contains(mobile);
    }
}
