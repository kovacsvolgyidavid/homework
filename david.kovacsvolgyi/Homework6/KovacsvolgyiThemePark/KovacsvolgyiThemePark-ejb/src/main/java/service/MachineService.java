package service;

import entity.Machine;
import facade.EntityFacade;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class MachineService {

    @Inject
    EntityFacade entityFacade;
    
    public Machine getMachineById(Long id){
        return entityFacade.getEntity(Machine.class, id);
    }

    public Machine addMachine(Machine machine) {
        entityFacade.addEntity(machine);
        return machine;
    }

    public List<Machine> getBuyableMachines() {
        return entityFacade.getQuery("machine.get_buyable_machines", Machine.class);
    }

}
