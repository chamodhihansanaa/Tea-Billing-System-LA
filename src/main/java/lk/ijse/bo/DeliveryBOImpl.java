package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.DeliveryDAO;
import lk.ijse.dto.DeliveryDTO;
import lk.ijse.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryBOImpl implements DeliveryBO{
    DeliveryDAO deliveryDAO = (DeliveryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public boolean update(Delivery delivery) {
        return false;
    }

    @Override
    public boolean save(Delivery delivery) {
        return false;
    }

    @Override
    public ArrayList<DeliveryDTO> getAllDelivery() throws SQLException, ClassNotFoundException {
        ArrayList<DeliveryDTO> allDelivery= new ArrayList<>();
        ArrayList<Delivery> all = deliveryDAO.getAll();
        for (Delivery c : all) {
            allDelivery.add(new DeliveryDTO(c.getCode(),c.getPrice(),c.getDate(),c.getAddress()));
        }
        return allDelivery;
    }

    @Override
    public boolean saveDelivery(DeliveryDTO dto) throws SQLException, ClassNotFoundException {
        return deliveryDAO.save(new Delivery(dto.getCode(), dto.getPrice(),dto.getDate(), dto.getAddress()));
    }

    @Override
    public boolean updateDelivery(DeliveryDTO dto) throws SQLException, ClassNotFoundException {
        return deliveryDAO.update(new Delivery(dto.getCode(),dto.getPrice(),dto.getDate(),dto.getAddress()));
    }

    @Override
    public boolean clearDelivery(String id) throws SQLException, ClassNotFoundException {
        return deliveryDAO.clear(id);
    }

    @Override
    public boolean deleteDelivery(String id) throws SQLException, ClassNotFoundException {
        return deliveryDAO.delete(id);
    }

    @Override
    public String generateNewDeliveryID() throws SQLException, ClassNotFoundException {
        return deliveryDAO.generateNewID();
    }

    @Override
    public Delivery searchByCode(String code) throws SQLException, ClassNotFoundException {
        return deliveryDAO.searchByCode(code);
    }
}


