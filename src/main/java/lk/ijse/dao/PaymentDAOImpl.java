package lk.ijse.dao;

import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public ArrayList<Collector> getAll() throws SQLException, ClassNotFoundException {
        ArrayList< Payment> allPayment= new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Payment");
        while (rst.next()) {
            Payment payment = new Payment(rst.getString("payment_id"), rst.getString("payment_method"), rst.getString("address"));
            allPayment.add(payment);
        }
        return allPayment;
    }
    @Override
    public boolean delete(String payment_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Payment WHERE payment_id=?", payment_id);
    }

    @Override
    public boolean save(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Payment (payment_id,payment_method, address) VALUES (?,?,?,?)",entity.getId(),entity.getPayment_method(),entity.getAddress());
    }

    @Override
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Payment SET payment_method=?,address=? WHERE payment_id=?",entity.getPayment_method(),entity.getAddress(),entity.getId());
    }

    @Override
    public boolean clear(String payment_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT payment_id FROM Payment WHERE payment_id=?", payment_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT payment_id FROM Payment ORDER BY payment_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("payment_id");
            int newPaymentId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newPaymentId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Payment search(String payment_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Payment WHERE payment_id=?",payment_id+"");
        rst.next();
        return new Payment(payment_id + "", rst.getString("payment_method"), rst.getString("address"));
    }



}














