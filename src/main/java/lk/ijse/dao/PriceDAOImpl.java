package lk.ijse.dao;

import lk.ijse.dao.custom.PriceDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.Price;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PriceDAOImpl implements PriceDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList< Price> allPrice= new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Price");
        while (rst.next()) {
            Price price = new Price(rst.getString("category"), rst.getString("duration"), rst.getString("kgprice"));
            allPrice.add(price);
        }
        return allPrice;
    }
    @Override
    public boolean delete(String category) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Price WHERE category=?", category);
    }

    @Override
    public boolean save(Price entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Price (category,duration, kgprice) VALUES (?,?,?,?)",entity.getCategory(),entity.getDuration(),entity.getPrice());
    }

    @Override
    public boolean update(Price entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Price SET duration=?,kgprice=? WHERE category=?",entity.getDuration(),entity.getPrice(),entity.getCategory());
    }

    @Override
    public boolean clear(String category) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT category FROM Price WHERE category=?", category);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT category FROM Price ORDER BY category DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("category");
            int newPriceId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newPriceId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Price search(String category) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Price WHERE category=?",category+"");
        rst.next();
        return new Price(category + "", rst.getString("duration"), rst.getString("kgprice"));
    }



}
















