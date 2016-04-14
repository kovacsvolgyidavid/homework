/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.entitypractice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author keni
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "Hunter.FindFeri",
            query = "SELECT h FROM Hunter h where h.name='Feri'"
    ),
    @NamedQuery(
            name = "Hunter.FindGeri",
            query = "SELECT h FROM Hunter h where h.name='Geri'"
    )})
public class Hunter implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Tag")
    @Column(name = "value")
    private List<String> licenceNumbers;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "hunter_fk")
    private List<Fox> killedFoxes;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "hunter_fk")
    private List<Rabbit> killedRabbits;

    public Hunter(String name) {
        this.name = name;
        this.killedRabbits = new ArrayList<>();
        this.killedFoxes = new ArrayList<>();
        this.licenceNumbers = new ArrayList<>();
    }

    public Hunter() {
        this.killedRabbits = new ArrayList<>();
        this.killedFoxes = new ArrayList<>();
        this.licenceNumbers = new ArrayList<>();
    }

    public void addLicence(String licenceNumber) {
        this.licenceNumbers.add(licenceNumber);

    }

    public void killFox(Fox fox) {
        this.killedFoxes.add(fox);

    }

    public void killRabbit(Rabbit rabbit) {
        this.killedRabbits.add(rabbit);
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLicenceNumbers() {
        return licenceNumbers;
    }

    public void setLicenceNumbers(List<String> licenceNumbers) {
        this.licenceNumbers = licenceNumbers;
    }

    public List<Fox> getKilledFoxes() {
        return killedFoxes;
    }

    public void setKilledFoxes(List<Fox> killedFoxes) {
        this.killedFoxes = killedFoxes;
    }

    public List<Rabbit> getKilledRabbits() {
        return killedRabbits;
    }

    public void setKilledRabbits(List<Rabbit> killedRabbits) {
        this.killedRabbits = killedRabbits;
    }
    
}
