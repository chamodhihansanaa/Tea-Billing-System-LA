package lk.ijse.dao;

import lk.ijse.dao.custom.SuperDAO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
       TEASUPPLIER ,COLLECTOR,EMPLOYEE,DELIVERY,ITEM,ORDERS,PAYMENT,PRICE,TEATYPE,TSCOLLECTDETAILS,COLLECTEMPDETAILS,ORDERITEMDETAILS,QUERY_DAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case TEASUPPLIER:
                return new TeaSupplierDAOImpl();
            case COLLECTOR:
                return new CollectorDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case DELIVERY:
                return new DeliveryDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case PRICE:
                return new PriceDAOImpl();
            case TEATYPE:
                return new TeaTypeDAOImpl();
            case TSCOLLECTDETAILS:
                return new TSCollectDetailsDAOImpl();
            case COLLECTEMPDETAILS:
                return new CollectEmpDetailsDAOImpl();
            case ORDERITEMDETAILS:
                return new OrderItemDetailsDAOImpl();
            case QUERY_DAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }


}


