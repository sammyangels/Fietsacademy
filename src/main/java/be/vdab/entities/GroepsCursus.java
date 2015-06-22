package be.vdab.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@DiscriminatorValue("G")
public class GroepsCursus extends Cursus {
    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.DATE)
    private Date van;
    @Temporal(TemporalType.DATE)
    private Date tot;
}
