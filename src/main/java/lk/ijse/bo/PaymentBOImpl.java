package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.dto.PaymentDTO;
import lk.ijse.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO{
   PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public ArrayList<PaymentDTO> getAllPayment() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentDTO> allPayment= new ArrayList<>();
        ArrayList<Payment> all = paymentDAO.getAll();
        for (Payment c : all) {
            allPayment.add(new PaymentDTO(c.getId(),c.getPayment_method(),c.getAddress()));
        }
        return allPayment;
    }

    @Override
    public boolean savePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.save(new Payment(dto.getId(), dto.getPayment_method(), dto.getAddress()));
    }

    @Override
    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(new Payment(dto.getId(),dto.getPayment_method(),dto.getAddress()));
    }

    @Override
    public boolean clearPayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.clear(id);
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(id);
    }

    @Override
    public String generateNewPaymentID() throws SQLException, ClassNotFoundException {
        return paymentDAO.generateNewID();
    }
}


