/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.entitypractice;

import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author keni
 */
@MappedSuperclass
@Inheritance
public abstract class Animal {

    @Enumerated(EnumType.STRING)
    protected FoodConsumption food;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date killed;

    public Animal() {
    }

    public Animal(FoodConsumption food, Date killed) {
        this.food = food;
        this.killed = killed;

    }

    public FoodConsumption getFood() {
        return food;
    }

    public void setFood(FoodConsumption food) {
        this.food = food;
    }

    public Date getKilled() {
        return killed;
    }

    public void setKilled(Date killed) {
        this.killed = killed;
    }

}
