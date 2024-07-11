package lk.ijse.dao.custom;

import lk.ijse.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collector;

public interface CollectorDAO extends CrudDAO<lk.ijse.entity.Collector> {
    public ArrayList<lk.ijse.entity.Collector> getAll() throws SQLException, ClassNotFoundException;
     boolean delete(String code) throws SQLException, ClassNotFoundException;

    boolean save(Collector entity) throws SQLException, ClassNotFoundException;

    boolean update(Collector entity) throws SQLException, ClassNotFoundException;


    boolean save(lk.ijse.entity.Collector entity) throws SQLException, ClassNotFoundException;

    boolean update(lk.ijse.entity.Collector entity) throws SQLException, ClassNotFoundException;
}
