package lk.ijse.bo;

import lk.ijse.dto.OrdersDTO;
import lk.ijse.entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrdersBO extends SuperBO{
     boolean update(Orders orders) ;

   boolean delete(String orderid) ;

     boolean save(Orders orders) ;

    Orders searchByOrderID(String orderid) ;

    ArrayList<OrdersDTO> getAllOrders() throws SQLException, ClassNotFoundException;

    boolean saveOrders(OrdersDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateOrders(OrdersDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearOrders(String id) throws SQLException, ClassNotFoundException;

    boolean deleteOrders(String id) throws SQLException, ClassNotFoundException;

    String generateNewOrdersID() throws SQLException, ClassNotFoundException;
}
