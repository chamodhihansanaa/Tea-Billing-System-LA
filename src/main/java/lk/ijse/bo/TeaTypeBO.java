package lk.ijse.bo;

import lk.ijse.dto.TeaTypeDTO;
import lk.ijse.entity.TeaType;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeaTypeBO extends SuperBO{
     TeaType searchByTeaID(String teaid) ;

     boolean update(TeaType teatype) ;

     boolean save(TeaType teatype) ;

     boolean delete(String teaid) ;

    ArrayList<TeaTypeDTO> getAllTeaType() throws SQLException, ClassNotFoundException;

    boolean saveTeaType(TeaTypeDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateTeaType(TeaTypeDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearTeaType(String id) throws SQLException, ClassNotFoundException;

    boolean deleteTeaType(String id) throws SQLException, ClassNotFoundException;

    String generateNewTeaTypeID() throws SQLException, ClassNotFoundException;
}
