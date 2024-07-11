package lk.ijse.bo;

import lk.ijse.entity.Item;
import lk.ijse.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO{
     boolean delete(String itemid) ;

     boolean save(Item item) ;

     boolean update(Item item) ;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearItem(String id) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    String generateNewItemID() throws SQLException, ClassNotFoundException;
}
