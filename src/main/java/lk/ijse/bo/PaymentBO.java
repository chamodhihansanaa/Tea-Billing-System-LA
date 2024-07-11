package lk.ijse.bo;

import lk.ijse.dto.PaymentDTO;
import lk.ijse.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO{
    Payment searchByPayment_ID(String paymentid) ;

     boolean update(Payment payment) ;

     boolean delete(String paymentid) ;

     boolean save(Payment payment) ;

    ArrayList<PaymentDTO> getAllPayment() throws SQLException, ClassNotFoundException;

    boolean savePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;

    boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearPayment(String id) throws SQLException, ClassNotFoundException;

    boolean deletePayment(String id) throws SQLException, ClassNotFoundException;

    String generateNewPaymentID() throws SQLException, ClassNotFoundException;
}
