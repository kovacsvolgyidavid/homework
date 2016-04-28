package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
public class ThemePark implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Address adsress;
    private Double money;
    private Double territory;

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
        return adsress;
    }

    public void setAdsress(Address adsress) {
        this.adsress = adsress;
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
