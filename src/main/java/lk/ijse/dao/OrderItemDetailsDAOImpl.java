package lk.ijse.dao;

import lk.ijse.dao.custom.OrderItemDetailsDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.OrderItemDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderItemDetailsDAOImpl implements OrderItemDetailsDAO {
    @Override
    public ArrayList<OrderItemDetails> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean save(OrderItemDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO CollectEmpDetails (or_id, i_id, date) VALUES (?,?,?,?)", entity.getOR_ID(), entity.getI_ID(), entity.getDate());
    }

    @Override
    public boolean update(OrderItemDetails entity) throws SQLException, ClassNotFoundException {
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
    public OrderItemDetails search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}






