package be.vdab.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cursussen")
public abstract class Cursus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;
    private String naam;

    @Override
    public String toString() {
        return naam;
    }
}
