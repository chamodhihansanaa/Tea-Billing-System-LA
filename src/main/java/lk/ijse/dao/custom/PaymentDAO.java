package lk.ijse.dao.custom;

import lk.ijse.entity.Payment;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment>{
    boolean save(Payment entity) throws SQLException, ClassNotFoundException;
}
