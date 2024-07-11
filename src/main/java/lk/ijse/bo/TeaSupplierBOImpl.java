package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.TeaSupplierDAO;
import lk.ijse.dto.TeaSupplierDTO;
import lk.ijse.entity.TeaSupplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeaSupplierBOImpl implements TeaSupplierBO{
    TeaSupplierDAO teaSupplierDAO= (TeaSupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TEASUPPLIER);

    @Override
    public boolean update(TeaSupplier teasupplier) {
        return false;
    }

    @Override
    public boolean save(TeaSupplier teasupplier) {
        return false;
    }

    @Override
    public boolean delete(String tsid) {
        return false;
    }

    @Override
    public ArrayList<TeaSupplierDTO> getAllTeaSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<TeaSupplierDTO> allTeaSupplier= new ArrayList<>();
        ArrayList<TeaSupplier> all = teaSupplierDAO.getAll();
        for (TeaSupplier c : all) {
           allTeaSupplier.add(new TeaSupplierDTO(c.getId(),c.getName(),c.getAddress(),c.getContact()));
        }
        return allTeaSupplier;
    }

    @Override
    public boolean saveTeaSupplier(TeaSupplierDTO dto) throws SQLException, ClassNotFoundException {
        return teaSupplierDAO.save(new TeaSupplier(dto.getId(), dto.getName(), dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean updateTeaSupplier(TeaSupplierDTO dto) throws SQLException, ClassNotFoundException {
        return teaSupplierDAO.update(new TeaSupplier(dto.getId(),dto.getName(),dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean clearTeaSupplier(String id) throws SQLException, ClassNotFoundException {
        return teaSupplierDAO.clear(id);
    }

    @Override
    public boolean deleteTeaSupplier(String id) throws SQLException, ClassNotFoundException {
        return teaSupplierDAO.delete(id);
    }

    @Override
    public String generateNewTeaSupplierID() throws SQLException, ClassNotFoundException {
        return teaSupplierDAO.generateNewID();
    }
}


