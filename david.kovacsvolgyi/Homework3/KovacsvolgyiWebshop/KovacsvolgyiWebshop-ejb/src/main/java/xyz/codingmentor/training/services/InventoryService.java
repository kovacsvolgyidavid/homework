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
public class InventoryService {//TODO újraírni

    private final Map<String, MobileDTO> mobiles = new HashMap<>();

    @PostConstruct
    private void addMobileOnStart() {
        mobiles.put("a5546f0e-c3b3-45ff-af84-87066b9e8ad0", new MobileDTO("a5546f0e-c3b3-45ff-af84-87066b9e8ad0", "3610", "Nokia", 50, 3));
        mobiles.put("a5546f0e-c3b3-45ff-af84-87066b9e8ad1", new MobileDTO("a5546f0e-c3b3-45ff-af84-87066b9e8ad1", "Lumia45", "Nokia", 500, 12));
        mobiles.put("a5546f0e-c3b3-45ff-af84-87066b9e8ad2", new MobileDTO("a5546f0e-c3b3-45ff-af84-87066b9e8ad2", "XperiaZ4", "Sony", 1, 5));
        mobiles.put("a5546f0e-c3b3-45ff-af84-87066b9e8ad3", new MobileDTO("a5546f0e-c3b3-45ff-af84-87066b9e8ad3", "10s", "iPhone", 99999999, 0));

    }

    public MobileDTO addMobile(MobileDTO mobil) {

        if (mobiles.get(mobil.getId()).equals(mobil)) {
            throw new IllegalArgumentException("We have this mobile in store, already.");
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
        if (listedMobile.getPiece() <= 0) {
            throw new SoldOutException("We don't have any of this mobile on stock :(");
        }
        listedMobile.setPiece(listedMobile.getPiece() - 1);
        return listedMobile.getPrice();

    }

    public List<MobileDTO> getMobilesList() {
        List<MobileDTO> mobileList = new ArrayList<>();
        Set<MobileDTO> mobileSet = new HashSet<>();
        mobiles.keySet().stream().forEach((id) -> {
            mobileSet.add(mobiles.get(id));
        });
        mobileList.addAll(mobileSet);
        return mobileList;
    }

    public boolean isItAMobile(MobileDTO mobile) {
        return mobiles.get(mobile.getId()).equals(mobile);
    }
}
