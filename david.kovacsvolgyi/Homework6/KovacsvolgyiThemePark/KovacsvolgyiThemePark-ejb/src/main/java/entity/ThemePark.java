package entity;

import dto.ThemeParkDTO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
public class ThemePark implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Address address;
    private Double money;
    private Double territory;
    @OneToMany(mappedBy = "themePark")
    private List<Machine> machines;
    public ThemePark() {
        //for mapping reasons
    }

    public ThemePark(ThemeParkDTO themeParkDto) {
        name=themeParkDto.getName();
        address=themeParkDto.getAddress();
        money=themeParkDto.getMoney();
        territory=themeParkDto.getTerritory();
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.address);
        hash = 89 * hash + Objects.hashCode(this.money);
        hash = 89 * hash + Objects.hashCode(this.territory);
        hash = 89 * hash + Objects.hashCode(this.machines);
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
        return true;
    }
    
}
