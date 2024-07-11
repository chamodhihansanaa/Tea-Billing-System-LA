package lk.ijse.dao.custom;

import lk.ijse.entity.CollectEmpDetails;

import java.sql.SQLException;

public interface CollectEmpDetailsDAO extends CrudDAO<CollectEmpDetails> {
    boolean save(CollectEmpDetails entity) throws SQLException, ClassNotFoundException;
}

