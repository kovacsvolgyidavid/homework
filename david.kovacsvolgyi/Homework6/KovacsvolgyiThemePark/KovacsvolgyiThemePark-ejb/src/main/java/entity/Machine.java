package entity;

import enumerated.MachineType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
public class Machine implements Serializable {

    @Id@GeneratedValue
    private Long id;
    private String name;
    @Column(name="SIZE_OF_MACHINE")
    private Double size;
    private Double ticketPrice;
    private Integer capacity;
    private MachineType machineType;
    @ManyToOne
    private ThemePark themePark;
    @OneToMany(mappedBy = "machine")
    private List<Guest> guests;
    public Machine() {
        //for mapping reasons
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
    
    public ThemePark getThemePark() {
        return themePark;
    }

    public void setThemePark(ThemePark themePark) {
        this.themePark = themePark;
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
