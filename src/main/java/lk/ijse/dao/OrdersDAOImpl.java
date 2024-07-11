package lk.ijse.dao;

import lk.ijse.dao.custom.OrdersDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Orders> allOrders= new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Orders");
        while (rst.next()) {
           Orders orders = new Orders(rst.getString("or_id"), rst.getString("date"), rst.getString("address"),rst.getString("quantity"));
            allOrders.add(orders);
        }
        return allOrders;
    }
    @Override
    public boolean delete(String or_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Orders WHERE or_id=?", or_id);
    }

    @Override
    public boolean save(Orders entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Orders (or_id,date, address,quantity) VALUES (?,?,?,?)",entity.getId(),entity.getDate(),entity.getAddress(),entity.getQuantity());
    }

    @Override
    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Orders SET date=?,address=?, quantity=? WHERE or_id=?",entity.getDate(),entity.getAddress(),entity.getQuantity(),entity.getId());
    }

    @Override
    public boolean clear(String or_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT or_id FROM Orders WHERE or_id=?", or_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT or_id FROM Orders ORDER BY or_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("or_id");
            int newOrdersId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newOrdersId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Orders search(String or_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Orders WHERE or_id=?",or_id+"");
        rst.next();
        return new Orders(or_id + "", rst.getString("date"), rst.getString("address"),rst.getString("quantity"));
    }



}












