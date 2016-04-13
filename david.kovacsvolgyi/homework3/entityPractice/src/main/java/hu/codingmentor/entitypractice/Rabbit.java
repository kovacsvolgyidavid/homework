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
        name="Rabbit.KillofFeri",
        query="SELECT h.hunter_id, r.id from,h.name  rabbit r outer join hunter h on h.hunter_id=r.hunter_id"
                + " where h.name ='Feri'"
)
})
public class Rabbit extends Animal implements Serializable {
    @Id@GeneratedValue
        private Long id;

    public Rabbit() {
    }

    public Rabbit(FoodConsumption food, Date killed) {
        super(food, killed);
    }

   
}
