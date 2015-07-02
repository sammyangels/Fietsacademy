package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.TelefoonNr;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "campussen")
public class Campus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String naam;
    @Embedded
    private Adres adres;

    @ElementCollection
    @CollectionTable(name = "campussentelefoonnrs", joinColumns = @JoinColumn(name = "campusid"))
    @OrderBy("fax")
    private Set<TelefoonNr> telefoonNrs;

    public Campus(String naam, Adres adres) {
        setNaam(naam);
        setAdres(adres);
        telefoonNrs = new LinkedHashSet<>();
    }

    public Set<TelefoonNr> getTelefoonNrs() {
        return Collections.unmodifiableSet(telefoonNrs);
    }

    public void addTelefoonNr(TelefoonNr telefoonNr) {
        telefoonNrs.add(telefoonNr);
    }

    public void removeTelefoonNr(TelefoonNr telefoonNr) {
        telefoonNrs.remove(telefoonNr);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    protected Campus() {}
}
