package be.vdab.services;

import be.vdab.dao.CampusDAO;
import be.vdab.entities.Campus;

import java.util.List;

public class CampusService {
    private final CampusDAO campusDAO = new CampusDAO();

    public List<Campus> findByGemeente(String gemeente) {
        return campusDAO.findByGemeente(gemeente);
    }

    public List<Campus> findAll() {
        return campusDAO.findAll();
    }

    public Campus read(long id) {
        return campusDAO.read(id);
    }
}
