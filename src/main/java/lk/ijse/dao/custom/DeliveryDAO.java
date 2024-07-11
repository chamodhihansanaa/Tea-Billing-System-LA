package lk.ijse.dao.custom;

import lk.ijse.entity.Collector;
import lk.ijse.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryDAO extends CrudDAO<Delivery>{
    public ArrayList<Delivery> getAll() throws SQLException, ClassNotFoundException;
    public boolean delete(String code) throws SQLException, ClassNotFoundException;
    public boolean save(Delivery entity) throws SQLException, ClassNotFoundException;
    public boolean update(Delivery entity) throws SQLException, ClassNotFoundException;
    public boolean clear(String code) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public Delivery searchByCode(String code) throws SQLException, ClassNotFoundException;
}
