package dto;

import entity.Guest;
import entity.Machine;
import enums.GuestState;
import java.util.Date;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class GuestDTO {
    private Long id;
    private GuestState state;
    private Double money;
    private Date enterTime;
    private int age;
    private Date birthDay;
    private Boolean active;
    private Machine machine;

    public GuestDTO() {
    }

    public GuestDTO(Guest guest) {
        id=guest.getId();
        state=guest.getState();
        money=guest.getMoney();
        enterTime=guest.getEnterTime();
        age=guest.getAge();
        active=guest.getActive();
        machine=guest.getMachine();
        birthDay=guest.getBirthDay();
        
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

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    
    
    
 
}
