package lk.ijse.dao.custom;

import lk.ijse.entity.TSCollectDetails;

import java.sql.SQLException;

public interface TSCollectDetailsDAO extends CrudDAO<TSCollectDetails> {
    boolean save(TSCollectDetails entity) throws SQLException, ClassNotFoundException;
}
