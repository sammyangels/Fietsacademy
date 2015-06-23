package be.vdab.dao;

import be.vdab.entities.Campus;

import java.util.List;

public class CampusDAO extends AbstractDAO {
    public List<Campus> findByGemeente(String gemeente) {
        return getEntityManager()
                .createNamedQuery("Campus.findByGemeente", Campus.class)
                .setParameter("gemeente", gemeente)
                .getResultList();
    }

    public List<Campus> findAll() {
        return getEntityManager()
                .createNamedQuery("Campus.findAll", Campus.class)
                .getResultList();
    }

    public Campus read(long id) {
        return getEntityManager().find(Campus.class, id);
    }
}
