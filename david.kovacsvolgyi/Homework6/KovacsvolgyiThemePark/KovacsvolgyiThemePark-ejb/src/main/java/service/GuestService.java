package service;

import entity.Guest;
import entity.Machine;
import enums.GuestState;
import facade.EntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class GuestService {

    @Inject
    EntityFacade entityFacade;

    public Guest addGuest(Guest guest) {
        guest.setId(null);
        guest.setState(GuestState.REST);
        guest.setActive(Boolean.FALSE);
        guest.setMachine(null);
        entityFacade.addEntity(guest);
        return guest;
    }

    public List<Guest> getGuestList() {
        return entityFacade.getQuery("guest.get_guests", Guest.class);
    }

    public Guest getGuestById(Long id) {
        return entityFacade.getEntity(Guest.class, id);
    }

    public Guest getDatabaseGuest(Guest guest) {
        Guest databaseGuest = entityFacade.getEntity(Guest.class, guest.getId());
        if (databaseGuest == null) {
            throw new IllegalArgumentException("We don't have this guest with id:" + guest.getId());
        }
        if (databaseGuest.equals(guest)) {
            return databaseGuest;
        } else {
            throw new IllegalArgumentException("This guest:" + guest.toString()
                    + "is not eqauls with the database one:" + databaseGuest.toString());
        }
    }
}
