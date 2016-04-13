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

public class Fox extends Animal {
    @Id@GeneratedValue
        private Long id;

    public Fox() {
    }

    public Fox(FoodConsumption food, Date killed) {
        super(food, killed);
    }
    
    
    
}
