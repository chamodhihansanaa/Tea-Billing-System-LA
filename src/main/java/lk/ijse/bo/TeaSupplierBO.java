package lk.ijse.bo;

import lk.ijse.dto.TeaSupplierDTO;
import lk.ijse.entity.TeaSupplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeaSupplierBO extends SuperBO{
     boolean update(TeaSupplier teasupplier) ;

     boolean save(TeaSupplier teasupplier) ;

     boolean delete(String tsid) ;

    ArrayList<TeaSupplierDTO> getAllTeaSupplier() throws SQLException, ClassNotFoundException;

    boolean saveTeaSupplier(TeaSupplierDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateTeaSupplier(TeaSupplierDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearTeaSupplier(String id) throws SQLException, ClassNotFoundException;

    boolean deleteTeaSupplier(String id) throws SQLException, ClassNotFoundException;

    String generateNewTeaSupplierID() throws SQLException, ClassNotFoundException;
}
