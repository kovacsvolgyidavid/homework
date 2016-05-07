package service;

import exception.NoSpaceException;
import entity.Guest;
import entity.Machine;
import exception.HasNotEnoughMoneyException;
import facade.EntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class MachineService {

    @Inject
    EntityFacade entityFacade;
    @Inject
    GuestService guestService;

    public Machine getMachineById(Long id) {
        return entityFacade.getEntity(Machine.class, id);
    }

    public Machine addMachine(Machine machine) {
        entityFacade.addEntity(machine);
        return machine;
    }

    public List<Machine> getBuyableMachines() {
        return entityFacade.getQuery("machine.get_buyable_machines", Machine.class);
    }

    public Machine getDatabaseMachine(Machine machine) {
        Machine databaseMachine = entityFacade.getEntity(Machine.class, machine.getId());
        if (databaseMachine == null) {
            throw new IllegalArgumentException("We don't have this machine with id:" + machine.getId());
        }
        if (databaseMachine.equals(machine)) {
            return databaseMachine;
        } else {
            throw new IllegalArgumentException("This machine:" + machine.toString()
                    + "is not eqauls with the database one:" + databaseMachine.toString());
        }
    }

    private void buyTicket(Guest guest, Machine machine) {
        if (guest.getThemePark().equals(machine.getThemePark())) {
            if (machine.getCapacity() == 0) {
                throw new NoSpaceException("There is no more free space on this machine:" + machine);
            }
            if (guest.getMoney() >= machine.getTicketPrice()) {
                guest.spend(machine.getTicketPrice());
                machine.getThemePark().earn(machine.getTicketPrice());
                guest.setMachine(machine);
                machine.decreaseCapacity();
            } else {
                throw new HasNotEnoughMoneyException("this guest:" + guest + "has not enough money for"
                        + "this machine:" + machine);
            }
        } else {
            throw new IllegalArgumentException("This guest" + guest + "is not in this themepark:" + machine.getThemePark());
        }
    }

    public Guest addGuestToMachine(Guest guest,Long id) {
            Machine machine=entityFacade.getEntity(Machine.class, id);
            Guest databaseGuest=guestService.getDatabaseGuest(guest);
            buyTicket(databaseGuest, machine);
            return databaseGuest;
    }
    public Guest exitMachine(Guest guest,Long id){
        Machine machine=entityFacade.getEntity(Machine.class, id);
        Guest databaseGuest=guestService.getDatabaseGuest(guest);
        if(machine.equals(databaseGuest.getMachine())){
            machine.increaseCapacity();
            databaseGuest.setMachine(null);
            return databaseGuest;
        }
        else{
            throw new IllegalArgumentException("this guest"+guest+" is not on this machine:"+machine);
        }
    }
}
