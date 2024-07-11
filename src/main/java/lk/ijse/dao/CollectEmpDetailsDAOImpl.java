package lk.ijse.dao;

import lk.ijse.dao.custom.CollectEmpDetailsDAO;
import lk.ijse.entity.CollectEmpDetails;
import lk.ijse.entity.Collector;

import java.sql.SQLException;
import java.util.ArrayList;

public class CollectEmpDetailsDAOImpl implements CollectEmpDetailsDAO {

    @Override
    public ArrayList<CollectEmpDetails> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean save(CollectEmpDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO CollectEmpDetails (collect_id, emp_id, date) VALUES (?,?,?,?)", entity.getCollect_ID(), entity.getEmp_ID(), entity.getDate());
    }

    @Override
    public boolean update(CollectEmpDetails entity) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean clear(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public CollectEmpDetails search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}




