package lk.ijse.dao;

import lk.ijse.dao.custom.TSCollectDetailsDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.TSCollectDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class TSCollectDetailsDAOImpl implements TSCollectDetailsDAO {
    @Override
    public ArrayList<TSCollectDetails> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean save(TSCollectDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO TSCollectDetails (collect_id, ts_id, amount_of_the_tea) VALUES (?,?,?,?)", entity.getCollect_ID(), entity.getTS_ID(), entity.getAmount_of_the_tea());
    }

    @Override
    public boolean update(TSCollectDetails entity) throws SQLException, ClassNotFoundException {
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
    public TSCollectDetails search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}


