package dto;

import entity.Machine;
import enums.MachineType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class MachineDTO {

    private Long id;
    private String name;
    private Double size;
    private Double ticketPrice;
    private Integer capacity;
    private MachineType machineType;
    private ThemeParkDTO themePark;
    private List<GuestDTO> guests;

    public MachineDTO(Machine machine) {
        id = machine.getId();
        name = machine.getName();
        size = machine.getSize();
        ticketPrice = machine.getTicketPrice();
        capacity = machine.getCapacity();
        machineType = machine.getMachineType();
        guests = new ArrayList<>();
        machine.getGuests().forEach(guest -> guests.add(new GuestDTO(guest)));
    }

    public MachineDTO() {
        //for mapping reasons
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public ThemeParkDTO getThemePark() {
        return themePark;
    }

    public void setThemePark(ThemeParkDTO themePark) {
        this.themePark = themePark;
    }

    public List<GuestDTO> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestDTO> guests) {
        this.guests = guests;
    }

}
