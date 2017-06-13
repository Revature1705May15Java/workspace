package com.rev.pojos;

import javax.persistence.*;

@Entity
@Table(name = "HONEYPOT")
public class Cave {
    @Id
    @Column(name = "C_ID")
    @SequenceGenerator(name = "CAVEID_SEQ", sequenceName = "CAVEID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAVEID_SEQ")
    private int id;

    @Column(name="SQ_FT")
    private double squareFootage;

    @Column
    private double rent;

    public Cave() {
    }

    public Cave(double squareFootage, double rent) {

        this.squareFootage = squareFootage;
        this.rent = rent;
    }

    public Cave(int id, double squareFootage, double rent) {

        this.id = id;
        this.squareFootage = squareFootage;
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Cave{" +
                "id=" + id +
                ", squareFootage=" + squareFootage +
                ", rent=" + rent +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
}
