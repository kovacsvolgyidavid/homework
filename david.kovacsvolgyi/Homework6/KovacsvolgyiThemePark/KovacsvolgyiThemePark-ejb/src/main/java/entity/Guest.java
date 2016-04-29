package entity;

import enums.GuestState;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.state);
        hash = 83 * hash + Objects.hashCode(this.money);
        hash = 83 * hash + Objects.hashCode(this.enterTime);
        hash = 83 * hash + Objects.hashCode(this.birthDay);
        hash = 83 * hash + Objects.hashCode(this.active);
        hash = 83 * hash + Objects.hashCode(this.machine);
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
        final Guest other = (Guest) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        if (!Objects.equals(this.enterTime, other.enterTime)) {
            return false;
        }
        if (!Objects.equals(this.birthDay, other.birthDay)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.machine, other.machine)) {
            return false;
        }
        return true;
    }
    
    
}
