package entity;

import dto.ThemeParkDTO;
import facade.EntityFacade;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "themepark.getAllGuests",
            query = "Select g from Guest g where g.themePark.id= :id")
})
public class ThemePark implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Address address;
    private Double money;
    private Double territory;
    private Double ticketPrice;
    private transient List<Machine> machines;
    private transient Set<Guest> guests;

    public ThemePark() {
        //for mapping reasons
    }

    @PrePersist
    private void initThemePark() {
        if (name == null) {

        }
        if (address == null) {

        }
        if (money == null) {
            money = 0.0;
        }
        if (territory == null) {
            territory = 1000.0;
        }
        if (ticketPrice == null) {
            ticketPrice = 0.0;
        }
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public ThemePark(ThemeParkDTO themeParkDto) {
        name = themeParkDto.getName();
        address = themeParkDto.getAddress();
        money = themeParkDto.getMoney();
        territory = themeParkDto.getTerritory();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Guest> getGuests(EntityFacade entityFacade) {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.address);
        hash = 89 * hash + Objects.hashCode(this.money);
        hash = 89 * hash + Objects.hashCode(this.territory);
        hash = 89 * hash + Objects.hashCode(this.machines);
        hash = 89 * hash + Objects.hashCode(this.guests);
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
        final ThemePark other = (ThemePark) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        if (!Objects.equals(this.territory, other.territory)) {
            return false;
        }
        if (!Objects.equals(this.machines, other.machines)) {
            return false;
        }
        if (!Objects.equals(this.guests, other.guests)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ThemePark{" + "id=" + id + ", name=" + name + ", address=" + address + ", money=" + money + ", territory=" + territory + '}';
    }

    public void spend(double spent) {
        this.money = -spent;
    }

    public void earn(double earned) {
        this.money = +earned;
    }

}
