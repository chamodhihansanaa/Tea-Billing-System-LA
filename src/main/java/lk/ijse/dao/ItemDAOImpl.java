package lk.ijse.dao;

import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItem = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            Item item = new Item(rst.getString("i_id"), rst.getString("description"), rst.getString("price"));
            allItem.add(item);
        }
        return allItem;
    }
    @Override
    public boolean delete(String i_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE i_id=?", i_id);
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (i_id,description,price) VALUES (?,?,?)",entity.getId(),entity.getDescription(),entity.getPrice());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?,price=? WHERE i_id=?",entity.getDescription(),entity.getPrice(),entity.getId());
    }

    @Override
    public boolean clear(String i_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT i_id FROM Item WHERE i_id=?", i_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT i_id FROM Item ORDER BY i_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("i_id");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Item search(String i_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Item WHERE i_id=?",i_id+"");
        rst.next();
        return new Item(i_id + "", rst.getString("description"), rst.getString("price"));
    }



}














