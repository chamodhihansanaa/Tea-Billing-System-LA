package lk.ijse.bo;

import lk.ijse.dto.DeliveryDTO;
import lk.ijse.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryBO extends SuperBO{
    boolean delete(String code);

    boolean update(Delivery delivery);

    boolean save(Delivery delivery);

    ArrayList<DeliveryDTO> getAllDelivery() throws SQLException, ClassNotFoundException;
    boolean saveDelivery(DeliveryDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateDelivery(DeliveryDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearDelivery(String id) throws SQLException, ClassNotFoundException;

    boolean deleteDelivery(String id) throws SQLException, ClassNotFoundException;

    String generateNewDeliveryID() throws SQLException, ClassNotFoundException;

    Delivery searchByCode(String code) throws SQLException, ClassNotFoundException;
}
