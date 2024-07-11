package lk.ijse.dao.custom;

import lk.ijse.entity.OrderItemDetails;

import java.sql.SQLException;

public interface OrderItemDetailsDAO extends CrudDAO<OrderItemDetails> {
    boolean save(OrderItemDetails entity) throws SQLException, ClassNotFoundException;
}

