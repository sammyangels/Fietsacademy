package be.vdab.services;

import be.vdab.dao.CursusDao;
import be.vdab.entities.Cursus;

import java.util.List;

public class CursusService {
    private final CursusDao cursusDao = new CursusDao();

    public List<Cursus> findByNaamContains(String woord) {
        return cursusDao.findByNaamContains(woord);
    }
}
