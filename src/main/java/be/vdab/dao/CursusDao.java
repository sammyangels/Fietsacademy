package be.vdab.dao;

import be.vdab.entities.Cursus;

import java.util.List;

public class CursusDao extends AbstractDAO {
    public List<Cursus> findByNaamContains(String woord) {
        return getEntityManager().createNamedQuery("Cursus.findByNaamContains", Cursus.class)
                .setParameter("zoals", "%" + woord + "%")
                .getResultList();
    }
}
