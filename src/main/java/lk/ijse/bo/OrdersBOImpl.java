package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.OrdersDAO;
import lk.ijse.dto.OrdersDTO;
import lk.ijse.entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersBOImpl implements OrdersBO{
    OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERS);
    @Override
    public ArrayList<OrdersDTO> getAllOrders() throws SQLException, ClassNotFoundException {
        ArrayList<OrdersDTO> allOrders= new ArrayList<>();
        ArrayList<Orders> all = ordersDAO.getAll();
        for (Orders c : all) {
           allOrders.add(new OrdersDTO(c.getId(),c.getDate(),c.getAddress(),c.getQuantity()));
        }
        return allOrders;
    }

    @Override
    public boolean saveOrders(OrdersDTO dto) throws SQLException, ClassNotFoundException {
        return ordersDAO.save(new Orders(dto.getId(), dto.getDate(), dto.getAddress(),dto.getQuantity()));
    }

    @Override
    public boolean updateOrders(OrdersDTO dto) throws SQLException, ClassNotFoundException {
        return ordersDAO.update(new Orders(dto.getId(),dto.getDate(),dto.getAddress(),dto.getQuantity()));
    }

    @Override
    public boolean clearOrders(String id) throws SQLException, ClassNotFoundException {
        return ordersDAO.clear(id);
    }

    @Override
    public boolean deleteOrders(String id) throws SQLException, ClassNotFoundException {
        return ordersDAO.delete(id);
    }

    @Override
    public String generateNewOrdersID() throws SQLException, ClassNotFoundException {
        return ordersDAO.generateNewID();
    }
}


