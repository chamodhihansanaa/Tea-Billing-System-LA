package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PriceDAO;
import lk.ijse.dto.PriceDTO;
import lk.ijse.entity.Price;

import java.sql.SQLException;
import java.util.ArrayList;

public class PriceBOImpl implements PriceBO{
    PriceDAO priceDAO = (PriceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRICE);
    @Override
    public ArrayList<PriceDTO> getAllPrice() throws SQLException, ClassNotFoundException {
        ArrayList<PriceDTO> allPrice= new ArrayList<>();
        ArrayList<Price> all = priceDAO.getAll();
        for (Price c : all) {
            allPrice.add(new PriceDTO(c.getCategory(),c.getDuration(),c.getPrice()));
        }
        return allPrice;
    }

    @Override
    public boolean savePrice(PriceDTO dto) throws SQLException, ClassNotFoundException {
        return priceDAO.save(new Price(dto.getCategory(), dto.getDuration(), dto.getPrice()));
    }

    @Override
    public boolean updatePrice(PriceDTO dto) throws SQLException, ClassNotFoundException {
        return priceDAO.update(new Price(dto.getCategory(),dto.getDuration(),dto.getPrice()));
    }

    @Override
    public boolean clearPrice(String category) throws SQLException, ClassNotFoundException {
        return priceDAO.clear(category);
    }

    @Override
    public boolean deletePrice(String category) throws SQLException, ClassNotFoundException {
        return priceDAO.delete(category);
    }

    @Override
    public String generateNewPriceID() throws SQLException, ClassNotFoundException {
        return priceDAO.generateNewID();
    }
}


