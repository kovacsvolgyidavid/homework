package dto;

import entity.Address;
import entity.ThemePark;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class ThemeParkDTO {
    private Long id;
    private String name;
    private Address address;
    private Double money;
    private Double territory;
    private List<MachineDTO> machines;

    public ThemeParkDTO(ThemePark themePark) {
        id=themePark.getId();
        name=themePark.getName();
        address=themePark.getAddress();
        money=themePark.getMoney();
        territory=themePark.getTerritory();
        machines=new ArrayList<>();
        themePark.getMachines().forEach(machine->machines.add(new MachineDTO(machine)));
    }

    public ThemeParkDTO() {
    //mapping reasons
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getTerritory() {
        return territory;
    }

    public void setTerritory(Double territory) {
        this.territory = territory;
    }

    public List<MachineDTO> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineDTO> machines) {
        this.machines = machines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
