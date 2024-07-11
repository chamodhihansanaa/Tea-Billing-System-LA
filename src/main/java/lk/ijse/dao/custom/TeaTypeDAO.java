package lk.ijse.dao.custom;

import lk.ijse.entity.TeaSupplier;
import lk.ijse.entity.TeaType;

import java.sql.SQLException;

public interface TeaTypeDAO extends CrudDAO<TeaType>{
    boolean save(TeaSupplier entity) throws SQLException, ClassNotFoundException;

    boolean save(TeaType entity) throws SQLException, ClassNotFoundException;

    boolean update(TeaSupplier entity) throws SQLException, ClassNotFoundException;
}
