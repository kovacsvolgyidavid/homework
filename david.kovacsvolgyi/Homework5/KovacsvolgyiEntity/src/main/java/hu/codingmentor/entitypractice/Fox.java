/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.entitypractice;

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
        name="Fox.KillofFeri",
        query="SELECT count(h.name) from  Rabbit r join Hunter h on h.id=r.hunter_fk"
                + " where h.name ='Feri'"
),
        @NamedQuery(
        name="Fox.KillofGeri",
        query="SELECT count(h.name) from  Rabbit r join Hunter h on h.id=r.hunter_fk"
                + " where h.name ='Geri'"
)
})
public class Fox extends Animal {
    @Id@GeneratedValue
        private Long id;

    public Fox() {
    }

    public Fox(FoodConsumption food, Date killed) {
        super(food, killed);
    }
    
    
    
}
