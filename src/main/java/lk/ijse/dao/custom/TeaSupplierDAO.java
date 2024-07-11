package lk.ijse.dao.custom;

import lk.ijse.entity.TeaSupplier;

import java.sql.SQLException;

public interface TeaSupplierDAO extends CrudDAO<TeaSupplier>{
    boolean save(TeaSupplier entity) throws SQLException, ClassNotFoundException;
}
