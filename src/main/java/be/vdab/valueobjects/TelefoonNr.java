package be.vdab.valueobjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@SuppressWarnings("JpaAttributeMemberSignatureInspection")
@Embeddable
public class TelefoonNr implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nummer;
    private boolean fax;
    private String opmerking;

    public TelefoonNr(String nummer, boolean fax, String opmerking) {

        this.nummer = nummer;
        this.fax = fax;
        this.opmerking = opmerking;
    }

    protected TelefoonNr() {}

    @Override
    public String toString() {
        return nummer;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TelefoonNr)) return false;

        TelefoonNr that = (TelefoonNr) o;

        return nummer.equalsIgnoreCase(that.nummer);

    }

    @Override
    public int hashCode() {
        return nummer.toUpperCase().hashCode();
    }

    public String getNummer() {
        return nummer;
    }

    public boolean isFax() {
        return fax;
    }

    public String getOpmerking() {
        return opmerking;
    }
}
