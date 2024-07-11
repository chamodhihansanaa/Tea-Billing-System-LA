package lk.ijse.dao;

import lk.ijse.dao.custom.TeaTypeDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.TeaType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeaTypeDAOImpl implements TeaTypeDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList< TeaType> allTeaType= new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM TeaType");
        while (rst.next()) {
            TeaType teaType = new TeaType(rst.getString("tea_id"), rst.getString("price"), rst.getString("tea_category"));
            allTeaType.add(teaType);
        }
        return allTeaType;
    }
    @Override
    public boolean delete(String tea_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM TeaType WHERE tea_id=?", tea_id);
    }

    @Override
    public boolean save(TeaType entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO TeaType (tea_id,price,tea_category) VALUES (?,?,?,?)",entity.getId(),entity.getId(),entity.getPrice(),entity.getTea_Category());
    }

    @Override
    public boolean update(TeaType entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE TeaType SET price=?,tea_category=? WHERE tea_id=?",entity.getPrice(),entity.getTea_Category(),entity.getId());
    }

    @Override
    public boolean clear(String tea_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT tea_id FROM TeaType WHERE tea_id=?", tea_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT tea_id FROM TeaType ORDER BY tea_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("tea_id");
            int newTeaTypeId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newTeaTypeId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public TeaType search(String tea_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM TeaType WHERE tea_id=?",tea_id+"");
        rst.next();
        return new TeaType(tea_id + "", rst.getString("price"), rst.getString("tea_category"));
    }



}















