package entity;

import enumerated.GuestState;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
public class Guest implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @Column(name="GUEST_STATE")
    private GuestState state;
    private Double money;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date enterTime;
    private int age;//TODO: nem ezt az adatot kell tárolni hanem a születési évet
    private Boolean active;

    public Guest() {
    //for mapping reasons
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GuestState getState() {
        return state;
    }

    public void setState(GuestState state) {
        this.state = state;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
}
