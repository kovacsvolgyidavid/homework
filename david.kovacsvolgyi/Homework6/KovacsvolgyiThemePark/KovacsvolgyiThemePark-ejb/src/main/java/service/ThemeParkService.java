package service;

import exception.HasNotEnoughMoneyException;
import dto.ThemeParkDTO;
import entity.Address;
import entity.Guest;
import entity.Machine;
import entity.ThemePark;
import facade.EntityFacade;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class ThemeParkService {

    @Inject
    EntityFacade entityFacade;
    @Inject
    GuestService guestService;
    @Inject
    MachineService machineService;

    public ThemePark createThemePark(ThemePark themePark) {
        Address address = themePark.getAddress();
        entityFacade.addEntity(address);
        entityFacade.addEntity(themePark);
        return themePark;
    }

    public ThemeParkDTO getThemeParkByIdDTO(Long id) {
        return new ThemeParkDTO(entityFacade.getEntity(ThemePark.class, id));
    }

    public ThemePark getThemeParkById(Long id) {
        return entityFacade.getEntity(ThemePark.class, id);
    }

    public Guest addGuestToThemePark(Long id, Guest guest) {
        ThemePark themePark = entityFacade.getEntity(ThemePark.class, id);
        Guest databaseGuest = guestService.getDatabaseGuest(guest);
        if (databaseGuest.getActive()) {
            if (databaseGuest.getThemePark().getId().equals(themePark.getId())) {
                throw new IllegalArgumentException("This Guest(id:" + databaseGuest.toString()
                        + ")already in this ThemePark");
            } else {
                throw new IllegalArgumentException("This Guest(id:" + databaseGuest.getId()
                        + ")already in an another ThemePark(id:" + databaseGuest.getThemePark().getId() + ")");
            }
        }
        databaseGuest.setActive(Boolean.TRUE);
        databaseGuest.setThemePark(themePark);
        payGuestToThemepark(databaseGuest, themePark);
        databaseGuest.setEnterTime(Calendar.getInstance().getTime());
        return databaseGuest;
    }

    public List<Guest> getGuests(Long id) {
        Query query = entityFacade.getQuery("themepark.getAllGuests");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public Guest deleteGuestFromThemePark(Long id, Guest guest) {
        Guest databaseGuest = guestService.getDatabaseGuest(guest);
        ThemePark themePark = entityFacade.getEntity(ThemePark.class, id);

        if (databaseGuest.getActive()) {
            if (!databaseGuest.getThemePark().getId().equals(id)) {
                throw new IllegalArgumentException("This guest:"
                        + databaseGuest.toString() + "is not in this themepark:" + themePark.toString());//TODO entity-k toString
            }
            databaseGuest.setActive(Boolean.FALSE);
            databaseGuest.setThemePark(null);
            databaseGuest.setEnterTime(null);
            return databaseGuest;
        } else {
            throw new IllegalArgumentException("This Guest:" + databaseGuest.toString()
                    + " is not in a themepark");
        }

    }

    private void payGuestToThemepark(Guest guest, ThemePark themePark) {
        if (guest.getMoney() >= themePark.getTicketPrice()) {
            guest.spend(themePark.getTicketPrice());
            themePark.earn(themePark.getTicketPrice());
        } else {
            throw new HasNotEnoughMoneyException("This guest:" + guest + "has not "
                    + "enough money for this themepark:" + themePark);
        }
    }

    private void buyMachine(Machine machine, ThemePark themePark) {
        if (themePark.getTerritory() < machine.getSize()) {
            throw new IllegalArgumentException("This themepark:" + themePark
                    + "can't buy this machine:" + machine + "because it hasn't got enough space for it.");
        }
        if (themePark.getMoney() >= machine.getPrice()) {
            themePark.spend(machine.getPrice());
            machine.setThemePark(themePark);
            themePark.setTerritory(themePark.getTerritory() - machine.getSize());
        } else {
            throw new HasNotEnoughMoneyException("This themepark:" + themePark + "has not "
                    + "enough money for this machine:" + machine);
        }
    }

    private void sellMachine(Machine machine, ThemePark themePark) {
            machine.setThemePark(null);
            themePark.earn(machine.getPrice());
            themePark.setTerritory(themePark.getTerritory()+machine.getSize());
    }

    public Machine addMachineToThemepark(Machine machine, Long id) {
        ThemePark themePark = entityFacade.getEntity(ThemePark.class, id);
        Machine databaseMachine = machineService.getDatabaseMachine(machine);
        if (databaseMachine.getThemePark() == null) {
            this.buyMachine(machine, themePark);
            return machine;
        } else {
            throw new IllegalArgumentException("This themepark" + themePark + " can't buy this machine" + machine + ", because it's already in an other themepark");
        }
    }
    
     public Machine deleteMachineFromThemepark(Machine machine, Long id) {
        ThemePark themePark = entityFacade.getEntity(ThemePark.class, id);
        Machine databaseMachine = machineService.getDatabaseMachine(machine);
        if(databaseMachine.getThemePark().equals(themePark)){
            this.sellMachine(machine, themePark);
            return machine;
        }
        else{
            throw new IllegalArgumentException("This machine"
                    +machine+"is not in this themepark:"+themePark);
        }
            
     }
}
