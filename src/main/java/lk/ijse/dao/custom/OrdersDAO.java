package lk.ijse.dao.custom;

import lk.ijse.entity.Orders;

import java.sql.SQLException;

public interface OrdersDAO extends CrudDAO<Orders>{
    boolean save(Orders entity) throws SQLException, ClassNotFoundException;
}
