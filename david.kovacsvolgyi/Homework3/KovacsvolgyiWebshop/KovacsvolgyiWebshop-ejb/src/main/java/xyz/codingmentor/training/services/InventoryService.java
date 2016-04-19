package xyz.codingmentor.training.services;

import xyz.codingmentor.training.dtos.MobileDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    private final Map<String, MobileDTO> mobiles = new HashMap<>();

    @PostConstruct
    private void addMobileOnStart() {
        MobileDTO mobile1 = new MobileDTO(UUID.randomUUID().toString(), "Lumia45", "Nokia", 500, 12);
        MobileDTO mobile2 = new MobileDTO(UUID.randomUUID().toString(), "3610", "Nokia", 50, 3);
        MobileDTO mobile3 = new MobileDTO(UUID.randomUUID().toString(), "XperiaZ4", "Sony", 1, 5);
        MobileDTO mobile4 = new MobileDTO(UUID.randomUUID().toString(), "10s", "iPhone", 99999999, 0);
        mobiles.put(mobile1.getId(), mobile1);
        mobiles.put(mobile2.getId(), mobile2);
        mobiles.put(mobile3.getId(), mobile3);
        mobiles.put(mobile4.getId(), mobile4);
    }

    public MobileDTO addMobile(MobileDTO mobil) {
        if (mobiles.get(mobil.getId()) != null && mobiles.get(mobil.getId()).equals(mobil)) {
            throw new IllegalArgumentException("We have " + mobil.getManufacturer() + mobil.getType() + "in store, already.");
        }
        mobil.setId(UUID.randomUUID().toString());
        mobiles.put(mobil.getId(), mobil);
        return mobil;
    }

    public Integer buyMobile(MobileDTO mobil) {
        if (!mobiles.containsKey(mobil.getId())) {
            throw new IllegalArgumentException("we don't have this kind of mobile");
        }
        MobileDTO listedMobile = mobiles.get(mobil.getId());
        listedMobile.setPiece(listedMobile.getPiece() - 1);
        return listedMobile.getPrice();
    }

    public List<MobileDTO> getMobilesList() {
        List<MobileDTO> mobileList = new ArrayList<>();
        Set<MobileDTO> mobileSet = new HashSet<>();
        mobiles.keySet().stream().forEach(id
                -> mobileSet.add(mobiles.get(id)));
        mobileList.addAll(mobileSet);
        return mobileList;
    }

    public boolean isItAMobile(MobileDTO mobile) {
        return mobiles.get(mobile.getId()).equals(mobile);
    }
}
