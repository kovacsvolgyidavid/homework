package entity;

import enumerated.GuestState;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    @Temporal(value=TemporalType.DATE)
    private Date birthDay;
    private Boolean active;
    @ManyToOne
    private Machine machine;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
    
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
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(this.birthDay);
        int age=Calendar.getInstance().get(Calendar.YEAR)-calendar.get(Calendar.YEAR);
        return age;
    }

   

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
}
