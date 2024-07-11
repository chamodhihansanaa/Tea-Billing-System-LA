package lk.ijse.dao;

import lk.ijse.dao.custom.TeaSupplierDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.TeaSupplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeaSupplierDAOImpl implements TeaSupplierDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList< TeaSupplier> allTeaSupplier= new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM TeaSupplier");
        while (rst.next()) {
            TeaSupplier teaSupplier = new TeaSupplier(rst.getString("ts_id"), rst.getString("name"), rst.getString("address"),rst.getString("contact"));
            allTeaSupplier.add(teaSupplier);
        }
        return allTeaSupplier;
    }
    @Override
    public boolean delete(String ts_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM TeaSupplier WHERE ts_id=?", ts_id);
    }

    @Override
    public boolean save(TeaSupplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO TeaSupplier (ts_id,name, address,contact) VALUES (?,?,?,?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public boolean update(TeaSupplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE TeaSupplier SET name=?,address=?,contact=? WHERE ts_id=?",entity.getName(),entity.getAddress(),entity.getContact(),entity.getId());
    }

    @Override
    public boolean clear(String ts_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT ts_id FROM TeaSupplier WHERE ts_id=?", ts_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT ts_id FROM TeaSupplier ORDER BY ts_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("ts_id");
            int newTeaSupplierId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newTeaSupplierId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public TeaSupplier search(String ts_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM TeaSupplier WHERE ts_id=?",ts_id+"");
        rst.next();
        return new TeaSupplier(ts_id + "", rst.getString("name"), rst.getString("address"), rst.getNString("contact"));
    }



}



















