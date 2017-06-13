package com.rev.pojos;

import javax.persistence.*;

@Entity
@Table(name = "HONEYPOT")
public class HoneyPot {
    @Id
    @Column(name = "H_ID")
    @SequenceGenerator(name = "HONEYPOTID_SEQ", sequenceName = "HONEYPOTID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HONEYPOTID_SEQ")
    private int id;

    @Column
    private double amount;

    public HoneyPot(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public HoneyPot(double amount) {
        this.amount = amount;
    }

    public HoneyPot() {
    }


}
