package lk.ijse.dao;

import lk.ijse.dao.custom.DeliveryDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public ArrayList<Delivery> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Delivery> allDelivery = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Delivery");
        while (rst.next()) {
           Delivery delivery = new Delivery(rst.getString("code"), rst.getString("price"), rst.getString("date"),rst.getString("address"));
            allDelivery.add(delivery);
        }
        return allDelivery;
    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Delivery WHERE code=?", code);
    }

    @Override
    public boolean save(Delivery entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Delivery (code, price,date, address) VALUES (?,?,?,?)",entity.getCode(),entity.getPrice(),entity.getDate(),entity.getAddress());
    }

    @Override
    public boolean update(Delivery entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Delivery SET price=?,date=?, address=? WHERE code=?",entity.getPrice(),entity.getDate(),entity.getAddress(),entity.getCode());
    }

    @Override
    public boolean clear(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Delivery WHERE code=?", code);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Delivery ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newDeliveryId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newDeliveryId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Delivery search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Delivery searchByCode(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Delivery WHERE code=?",code+"");
        rst.next();
        return new Delivery(code + "", rst.getString("price"), rst.getString("date"),rst.getString("address"));
    }



}








