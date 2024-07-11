package lk.ijse.bo;

import lk.ijse.dao.custom.CollectorDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.CollectorDTO;
import lk.ijse.entity.Collector;

import java.sql.SQLException;
import java.util.ArrayList;

public class CollectorBOImpl implements CollectorBO {
    CollectorDAO collectorDAO = (CollectorDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COLLECTOR);

    @Override
    public boolean delete(String collectId) {
        return false;
    }

    @Override
    public boolean save(Collector collector) {
        return false;
    }

    @Override
    public Collector searchByCollect_ID(String collectId) {
        return null;
    }

    @Override
    public boolean update(Collector collector) {
        return false;
    }

    @Override
    public ArrayList<CollectorDTO> getAllCollector() throws SQLException, ClassNotFoundException {
        ArrayList<CollectorDTO> allCollector= new ArrayList<>();
        ArrayList<Collector> all = collectorDAO.getAll();
        for (Collector c : all) {
            allCollector.add(new CollectorDTO(c.getId(),c.getName(),c.getAddress(),c.getContact()));
        }
        return allCollector;
    }

    @Override
    public boolean saveCollector(CollectorDTO dto) throws SQLException, ClassNotFoundException {
        return collectorDAO.save(new Collector(dto.getId(), dto.getName(), dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean updateCollector(CollectorDTO dto) throws SQLException, ClassNotFoundException {
        return collectorDAO.update(new Collector(dto.getId(),dto.getName(),dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean clearCollector(String id) throws SQLException, ClassNotFoundException {
        return collectorDAO.clear(id);
    }

    @Override
    public boolean deleteCollector(String id) throws SQLException, ClassNotFoundException {
        return collectorDAO.delete(id);
    }

    @Override
    public String generateNewCollectorID() throws SQLException, ClassNotFoundException {
        return collectorDAO.generateNewID();
    }
}



