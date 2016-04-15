/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor.training.main;

import xyz.codingmentor.training.entitypractice.FoodConsumption;
import xyz.codingmentor.training.entitypractice.Fox;
import xyz.codingmentor.training.entitypractice.Hunter;
import xyz.codingmentor.training.entitypractice.Rabbit;
import java.util.Calendar;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author keni
 */
public class Main {

    private Main() {
        //to hide default constructor
    }

    public static void main(String[] args) {
        Hunter hunter1 = new Hunter("Feri");
        Hunter hunter2 = new Hunter("Geri");
        Fox vuk1 = new Fox(FoodConsumption.MEAT, Calendar.getInstance().getTime());
        Fox vuk2 = new Fox(FoodConsumption.MEAT, Calendar.getInstance().getTime());
        Fox vuk3 = new Fox(FoodConsumption.MEAT, Calendar.getInstance().getTime());
        Fox vuk4 = new Fox(FoodConsumption.MEAT, Calendar.getInstance().getTime());
        Fox vuk5 = new Fox(FoodConsumption.MEAT, Calendar.getInstance().getTime());
        Rabbit rabbit1 = new Rabbit(FoodConsumption.HERBIVORE, Calendar.getInstance().getTime());
        Rabbit rabbit2 = new Rabbit(FoodConsumption.HERBIVORE, Calendar.getInstance().getTime());
        Rabbit rabbit3 = new Rabbit(FoodConsumption.HERBIVORE, Calendar.getInstance().getTime());
        Rabbit rabbit4 = new Rabbit(FoodConsumption.HERBIVORE, Calendar.getInstance().getTime());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(hunter1);
        hunter1.addLicence(UUID.randomUUID().toString());
        hunter1.addLicence(UUID.randomUUID().toString());
        hunter1.addLicence(UUID.randomUUID().toString());
        hunter1.addLicence(UUID.randomUUID().toString());
        hunter1.addLicence(UUID.randomUUID().toString());
        hunter1.addLicence(UUID.randomUUID().toString());
        em.persist(hunter2);
        hunter2.addLicence(UUID.randomUUID().toString());
        hunter2.addLicence(UUID.randomUUID().toString());
        hunter2.addLicence(UUID.randomUUID().toString());
        hunter2.addLicence(UUID.randomUUID().toString());
        hunter2.addLicence(UUID.randomUUID().toString());
        em.persist(vuk1);
        hunter1.killFox(vuk1);
        em.persist(vuk2);
        hunter1.killFox(vuk2);
        em.persist(vuk3);
        hunter1.killFox(vuk3);
        em.persist(vuk4);
        hunter2.killFox(vuk4);
        em.persist(vuk5);
        hunter2.killFox(vuk5);
        em.persist(rabbit1);
        hunter2.killRabbit(rabbit1);
        em.persist(rabbit2);
        hunter2.killRabbit(rabbit2);
        em.persist(rabbit3);
        hunter1.killRabbit(rabbit3);
        em.persist(rabbit4);
        hunter1.killRabbit(rabbit4);
        tx.commit();

    }
}
