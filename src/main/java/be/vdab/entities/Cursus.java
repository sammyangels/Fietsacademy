package be.vdab.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cursus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    private String naam;

    @Override
    public String toString() {
        return naam;
    }
}
