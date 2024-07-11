package lk.ijse.bo;

import lk.ijse.dto.CollectorDTO;
import lk.ijse.entity.Collector;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CollectorBO extends SuperBO{
    boolean delete(String collectId);

    boolean save(Collector collector);

    Collector searchByCollect_ID(String collectId);

    boolean update(Collector collector);

    ArrayList<CollectorDTO> getAllCollector() throws SQLException, ClassNotFoundException;

    boolean saveCollector(CollectorDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateCollector(CollectorDTO dto) throws SQLException, ClassNotFoundException;
    boolean clearCollector(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCollector(String id) throws SQLException, ClassNotFoundException;

    String generateNewCollectorID() throws SQLException, ClassNotFoundException;


}
