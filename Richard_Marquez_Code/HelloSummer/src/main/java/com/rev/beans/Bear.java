package com.rev.beans;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "findBearByName", query = "from Bear where name = :namevar")
})


@Component
@Entity
@Table(name = "BEAR")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "BEAR_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "BEAR_NAME")),
        @AttributeOverride(name = "cave", column = @Column(name = "BEAR_CAVE"))
})
public class Bear extends Animal implements Serializable {
    private static final long serialVersionUID = 2L;

    @Column(name = "BEAR_WEIGHT")
    private int weight;

    public Bear() {
    }

    public Bear(String name, int weight, Cave cave) {
        this.name = name;
        this.weight = weight;
        this.cave = cave;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
