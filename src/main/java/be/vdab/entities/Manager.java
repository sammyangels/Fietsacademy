package be.vdab.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "managers")
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String voornaam;
    private String familienaam;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "manager")
    private Campus campus;

    public Long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public Campus getCampus() {
        return campus;
    }
}
