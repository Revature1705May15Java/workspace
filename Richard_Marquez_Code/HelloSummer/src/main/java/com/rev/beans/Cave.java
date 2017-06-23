package com.rev.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CAVE")
public class Cave implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caveSeq")
    @SequenceGenerator(allocationSize = 1, name = "caveSeq", sequenceName = "CAVE_SEQ")
    @Column(name = "CAVE_ID")
    private int id;

    @Column(name = "CAVE_NAME")
    private String name;


    @OneToMany(mappedBy = "cave", fetch = FetchType.EAGER)
    List<Animal> occupants;

    public Cave() {
    }

    public Cave(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<Animal> occupants) {
        this.occupants = occupants;
    }
}
