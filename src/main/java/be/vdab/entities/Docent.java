package be.vdab.entities;

import be.vdab.enums.Geslacht;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "docenten")
public class Docent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;
    private long rijksRegisterNr;

    @ElementCollection
    @CollectionTable(name = "docentenbijnamen", joinColumns = @JoinColumn(name = "docentid"))
    @Column(name = "Bijnaam")
    private Set<String> bijnamen;

    @Enumerated(EnumType.STRING)
    private Geslacht geslacht;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campusid")
    private Campus campus;

    @ManyToMany
    @JoinTable(
            name = "docentenverantwoordelijkheden",
            joinColumns = @JoinColumn(name="docentId"),
            inverseJoinColumns = @JoinColumn(name="verantwoordelijkheidId"))
    private Set<Verantwoordelijkheid> verantwoordelijkheden;

    public void addVerantwoordelijkheid(Verantwoordelijkheid verantwoordelijkheid) {
        verantwoordelijkheden.add(verantwoordelijkheid);
        if (!verantwoordelijkheid.getDocenten().contains(this)) {
            verantwoordelijkheid.addDocent(this);
        }
    }

    public void removeVerantwoordelijkheid(Verantwoordelijkheid verantwoordelijkheid) {
        verantwoordelijkheden.remove(verantwoordelijkheid);
        if (verantwoordelijkheid.getDocenten().contains(this)) {
            verantwoordelijkheid.removeDocent(this);
        }
    }

    public Set<Verantwoordelijkheid> getVerantwoordelijkheden() {
        return Collections.unmodifiableSet(verantwoordelijkheden);
    }
    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        if (this.campus != null && this.campus.getDocenten().contains(this)) {
            this.campus.removeDocent(this);         // als de andere kant nog niet bijgewerkt is werk je de andere kant bij
        }
        this.campus = campus;
        if (campus != null && !campus.getDocenten().contains(this)) {
            campus.addDocent(this);                 // als de andere kant nog niet bijgewerkt is werk je de andere kant bij
        }
    }

    protected Docent() {}

    public Docent(String voornaam, String familienaam, BigDecimal wedde, long rijksRegisterNr, Geslacht geslacht) {
        setVoornaam(voornaam);
        setFamilienaam(familienaam);
        setWedde(wedde);
        setRijksRegisterNr(rijksRegisterNr);
        setGeslacht(geslacht);
        bijnamen = new HashSet<>();
        verantwoordelijkheden = new LinkedHashSet<>();
    }

    public void addBijnaam(String bijnaam) {
        bijnamen.add(bijnaam);
    }

    public void removeBijnaam(String bijnaam) {
        bijnamen.remove(bijnaam);
    }

    public Set<String> getBijnamen() {
        return Collections.unmodifiableSet(bijnamen);
    }

    public static boolean isVoornaamValid(String voornaam) {
        return voornaam != null && !voornaam.isEmpty();
    }

    public static boolean isFamilienaamValid(String familienaam) {
        return familienaam != null && !familienaam.isEmpty();
    }

    public static boolean isWeddeValid(BigDecimal wedde) {
        return wedde != null && wedde.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isRijksRegisterNrValid(long rijksRegisterNr) {
        long getal = rijksRegisterNr / 100;
        if (rijksRegisterNr / 1_000_000_000 < 50) {
            getal += 2_000_000_000;
        }
        return rijksRegisterNr % 100 == 97 - getal % 97;
    }

    public void setVoornaam(String voornaam) {
        if (!isVoornaamValid(voornaam)) {
            throw new IllegalArgumentException();
        }
        this.voornaam = voornaam;
    }

    public void setFamilienaam(String familienaam) {
        if (!isFamilienaamValid(familienaam)) {
            throw new IllegalArgumentException();
        }
        this.familienaam = familienaam;
    }

    public void setWedde(BigDecimal wedde) {
        if (!isWeddeValid(wedde)) {
            throw new IllegalArgumentException();
        }
        this.wedde = wedde;
    }

    public void setRijksRegisterNr(long rijksRegisterNr) {
        if (!isRijksRegisterNrValid(rijksRegisterNr)) {
            throw new IllegalArgumentException();
        }
        this.rijksRegisterNr = rijksRegisterNr;
    }

    public void opslag(BigDecimal percentage) {
        BigDecimal factor = BigDecimal.ONE.add(percentage.divide(BigDecimal.valueOf(100)));
        wedde = wedde.multiply(factor).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Docent)) {
            return false;
        }
        return ((Docent) o).rijksRegisterNr == rijksRegisterNr;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(rijksRegisterNr).hashCode();
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public BigDecimal getWedde() {
        return wedde;
    }

    public long getRijksRegisterNr() {
        return rijksRegisterNr;
    }

    public String getNaam() {
        return voornaam + ' ' + familienaam;
    }


}