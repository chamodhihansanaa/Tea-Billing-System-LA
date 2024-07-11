package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.TeaTypeDAO;
import lk.ijse.dto.TeaTypeDTO;
import lk.ijse.entity.TeaType;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeaTypeBOImpl implements TeaTypeBO{
    TeaTypeDAO teaTypeDAO = (TeaTypeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TEATYPE);

    @Override
    public TeaType searchByTeaID(String teaid) {
        return null;
    }

    @Override
    public boolean update(TeaType teatype) {
        return false;
    }

    @Override
    public boolean save(TeaType teatype) {
        return false;
    }

    @Override
    public boolean delete(String teaid) {
        return false;
    }

    @Override
    public ArrayList<TeaTypeDTO> getAllTeaType() throws SQLException, ClassNotFoundException {
        ArrayList<TeaTypeDTO> allTeaType= new ArrayList<>();
        ArrayList<TeaType> all = teaTypeDAO.getAll();
        for (TeaType c : all) {
            allTeaType.add(new TeaTypeDTO(c.getId(),c.getPrice(),c.getTea_Category()));
        }
        return allTeaType;
    }

    @Override
    public boolean saveTeaType(TeaTypeDTO dto) throws SQLException, ClassNotFoundException {
        return teaTypeDAO.save(new TeaType(dto.getId(), dto.getPrice(), dto.getTea_Category()));
    }

    @Override
    public boolean updateTeaType(TeaTypeDTO dto) throws SQLException, ClassNotFoundException {
        return teaTypeDAO.update(new TeaType(dto.getId(),dto.getPrice(),dto.getTea_Category()));
    }

    @Override
    public boolean clearTeaType(String id) throws SQLException, ClassNotFoundException {
        return teaTypeDAO.clear(id);
    }

    @Override
    public boolean deleteTeaType(String id) throws SQLException, ClassNotFoundException {
        return teaTypeDAO.delete(id);
    }

    @Override
    public String generateNewTeaTypeID() throws SQLException, ClassNotFoundException {
        return teaTypeDAO.generateNewID();
    }
}


