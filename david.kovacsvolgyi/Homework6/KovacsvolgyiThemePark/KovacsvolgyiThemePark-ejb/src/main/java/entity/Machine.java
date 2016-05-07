package entity;

import enums.MachineType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "machine.get_buyable_machines",
            query = "select m from Machine m where m.themePark is null")
})
public class Machine implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Double price;//TODO:hashcode + tostring + iylenek
    private String name;
    @Column(name = "SIZE_OF_MACHINE")
    private Double size;
    private Double ticketPrice;
    private Integer capacity;
    private MachineType machineType;
    @ManyToOne
    @JoinColumn(name = "THEME_PARK_FK")
    private ThemePark themePark;
    private transient List<Guest> guests;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.size);
        hash = 11 * hash + Objects.hashCode(this.ticketPrice);
        hash = 11 * hash + Objects.hashCode(this.capacity);
        hash = 11 * hash + Objects.hashCode(this.machineType);
        hash = 11 * hash + Objects.hashCode(this.themePark);
        hash = 11 * hash + Objects.hashCode(this.guests);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Machine other = (Machine) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.ticketPrice, other.ticketPrice)) {
            return false;
        }
        if (!Objects.equals(this.capacity, other.capacity)) {
            return false;
        }
        if (this.machineType != other.machineType) {
            return false;
        }
        if (!Objects.equals(this.themePark, other.themePark)) {
            return false;
        }
        if (!Objects.equals(this.guests, other.guests)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Machine{" + "id=" + id + ", name=" + name + ", size=" + size + ", ticketPrice=" + ticketPrice + ", capacity=" + capacity + ", machineType=" + machineType + ", themePark=" + themePark + '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void decreaseCapacity() {
        capacity--;
    }

    public void increaseCapacity() {
        capacity++;
    }
    
}
