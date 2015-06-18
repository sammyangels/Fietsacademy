package be.vdab.dao;

import be.vdab.entities.Docent;
import be.vdab.filters.JPAFilter;

import javax.persistence.EntityManager;
import javax.print.Doc;
import java.math.BigDecimal;
import java.util.List;

public class DocentDAO extends AbstractDAO {
    public Docent read(long id) {
        return getEntityManager().find(Docent.class, id);
    }

    public void create(Docent docent) {
        getEntityManager().persist(docent);
    }

    public void delete(long id) {
        Docent docent = getEntityManager().find(Docent.class, id);
        if (docent != null) {
            getEntityManager().remove(docent);
        }
    }

    public List<Docent> findByWeddeBetween(BigDecimal van, BigDecimal tot) {
        return getEntityManager().createQuery("select d from Docent d", Docent.class).getResultList();
    }
}
