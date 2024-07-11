package lk.ijse.dao;

import lk.ijse.dao.custom.CollectorDAO;
import lk.ijse.entity.Collector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CollectorDAOImpl implements CollectorDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Collector> allCollectors = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Collector");
        while (rst.next()) {
            Collector collector = new Collector(rst.getString("collect_id"), rst.getString("name"), rst.getString("address"),rst.getString("contactno"));
           allCollectors.add(collector);
        }
        return allCollectors;
    }
    @Override
    public boolean delete(String collect_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Collector WHERE collect_id=?", collect_id);
    }

    @Override
    public boolean save(java.util.stream.Collector entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(java.util.stream.Collector entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Collector entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Collector (collect_id, name, address, contact) VALUES (?,?,?,?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public boolean update(Collector entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Collector SET name=?, address=?, contact=? WHERE collect_id=?",entity.getName(),entity.getAddress(),entity.getContact(),entity.getId());
    }

    @Override
    public boolean clear(String collect_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT collect_id FROM Collector WHERE collect_id=?", collect_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT collect_id FROM Collector ORDER BY collect_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("collect_id");
            int newCollectorId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newCollectorId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Collector search(String collect_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Collector WHERE collect_id=?",collect_id+"");
        rst.next();
        return new Collector(collect_id + "", rst.getString("name"), rst.getString("address"),rst.getString("contactno"));
    }
}






