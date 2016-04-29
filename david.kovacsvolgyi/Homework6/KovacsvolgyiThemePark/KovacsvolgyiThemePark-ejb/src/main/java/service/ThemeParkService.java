package service;

import dto.ThemeParkDTO;
import entity.Address;
import entity.Machine;
import entity.ThemePark;
import facade.EntityFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class ThemeParkService {

    @Inject
    EntityFacade entityFacade;

    public ThemePark createThemePark(ThemePark themePark) {
        Address address = themePark.getAddress();
        entityFacade.addEntity(address);
        entityFacade.addEntity(themePark);
        return themePark;
    }

    public ThemePark addMachine(Machine machine, Long id) {
        ThemePark themePark = entityFacade.getEntity(ThemePark.class, id);
        entityFacade.addEntity(machine);
        themePark.getMachines().add(machine);
        return themePark;
    }

    public ThemeParkDTO getThemeParkByIdDTO(Long id) {
        return new ThemeParkDTO(entityFacade.getEntity(ThemePark.class, id));
    }

    public ThemePark getThemeParkById(Long id) {
        return entityFacade.getEntity(ThemePark.class, id);
    }

}
