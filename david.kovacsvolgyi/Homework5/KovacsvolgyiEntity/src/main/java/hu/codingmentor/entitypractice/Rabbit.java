/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.entitypractice;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author keni
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "Rabbit.KillofFeri",
            query = "SELECT count(h.name) from  Rabbit r join Hunter h on h.id=r.hunter_fk"
            + " where h.name ='Feri'"
    ),
    @NamedQuery(
            name = "Rabbit.KillofGeri",
            query = "SELECT count(h.name) from  Rabbit r join Hunter h on h.id=r.hunter_fk"
            + " where h.name ='Geri'"
    )
})
public class Rabbit extends Animal implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    public Rabbit() {
        //this is for mapping purposes
    }

    public Rabbit(FoodConsumption food, Date killed) {
        super(food, killed);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
