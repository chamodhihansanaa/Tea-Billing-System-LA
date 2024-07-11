package lk.ijse.bo;

import lk.ijse.dto.PriceDTO;
import lk.ijse.entity.Price;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PriceBO extends SuperBO{

     boolean update(Price price) ;

     boolean save(Price price) ;

     boolean delete(String duration) ;

    ArrayList<PriceDTO> getAllPrice() throws SQLException, ClassNotFoundException;

    boolean savePrice(PriceDTO dto) throws SQLException, ClassNotFoundException;

    boolean updatePrice(PriceDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearPrice(String id) throws SQLException, ClassNotFoundException;

    boolean deletePrice(String category) throws SQLException, ClassNotFoundException;

    String generateNewPriceID() throws SQLException, ClassNotFoundException;
}
