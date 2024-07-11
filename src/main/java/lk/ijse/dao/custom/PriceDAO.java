package lk.ijse.dao.custom;

import lk.ijse.entity.Price;

import java.sql.SQLException;

public interface PriceDAO extends CrudDAO<Price>{
    boolean save(Price entity) throws SQLException, ClassNotFoundException;
}
