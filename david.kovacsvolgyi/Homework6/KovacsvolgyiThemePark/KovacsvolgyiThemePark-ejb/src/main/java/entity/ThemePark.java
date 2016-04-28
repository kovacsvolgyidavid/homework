package entity;

import java.io.Serializable;
import java.util.List;
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
    @OneToOne
    private Address address;
    private Double money;
    private Double territory;
    @OneToMany(mappedBy = "themePark")
    private List<Machine> machines;
    public ThemePark() {
        //for mapping reasons
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAdsress() {
        return address;
    }

    public void setAdsress(Address adsress) {
        this.address = adsress;
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

}
