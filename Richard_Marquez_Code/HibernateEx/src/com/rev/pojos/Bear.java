package com.rev.pojos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BEAR")
public class Bear {
    @Id
    @Column(name = "B_ID")
    @SequenceGenerator(name = "BEARID_SEQ", sequenceName = "BEARID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEARID_SEQ")
    private int id;

    @Column
    private String color;

    @Column
    private String breed;

    @Column
    private double height;

    @Column
    private double weight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "BEAR_HOME")
    private Cave dwelling;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "HONEYPOT_ID")
    private HoneyPot honeyPot;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PARENT_CUB", joinColumns = @JoinColumn(name = "PARENT_ID"), inverseJoinColumns = @JoinColumn(name = "CUB_ID"))
    private Set<Bear> cubs;

    public Bear(String color, String breed, double height, double weight) {
        this.color = color;
        this.breed = breed;
        this.height = height;
        this.weight = weight;
    }

    public Bear() {
        this.cubs = new HashSet<>();
    }

    public Bear(String color, String breed, double height, double weight, Cave dwelling, HoneyPot honeyPot) {

        this.color = color;
        this.breed = breed;
        this.height = height;
        this.weight = weight;
        this.dwelling = dwelling;
        this.honeyPot = honeyPot;
    }

    public Bear(String color, String breed, double height, double weight, Cave dwelling, HoneyPot honeyPot, Set<Bear> cubs) {

        this.color = color;
        this.breed = breed;
        this.height = height;
        this.weight = weight;
        this.dwelling = dwelling;
        this.honeyPot = honeyPot;
        this.cubs = cubs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Cave getDwelling() {
        return dwelling;
    }

    public void setDwelling(Cave dwelling) {
        this.dwelling = dwelling;
    }

    public HoneyPot getHoneyPot() {
        return honeyPot;
    }

    public void setHoneyPot(HoneyPot honeyPot) {
        this.honeyPot = honeyPot;
    }

    public Set<Bear> getCubs() {
        return cubs;
    }

    public void setCubs(Set<Bear> cubs) {
        this.cubs = cubs;
    }
}
