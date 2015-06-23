package be.vdab.entities;

import be.vdab.valueobjects.Adres;

import javax.persistence.*;
import java.io.Serializable;

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

    public Campus(String naam, Adres adres) {
        setNaam(naam);
        setAdres(adres);
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
