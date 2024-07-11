package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Item;
import lk.ijse.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{


    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItem= new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item c : all) {
            allItem.add(new ItemDTO(c.getId(),c.getDescription(),c.getPrice()));
        }
        return allItem;
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(dto.getId(), dto.getDescription(), dto.getPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getId(),dto.getDescription(),dto.getPrice()));
    }

    @Override
    public boolean clearItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.clear(id);
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public String generateNewItemID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}


