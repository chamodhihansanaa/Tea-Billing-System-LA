package lk.ijse.bo;

import lk.ijse.dao.PriceDAOImpl;
import lk.ijse.dao.TeaSupplierDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        TEASUPPLIER,COLLECTOR,EMPLOYEE,ITEM,ORDERS,PAYMENT,DELIVERY,TEATYPE,PRICE
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case TEASUPPLIER:
                return new TeaSupplierBOImpl();
            case COLLECTOR:
                return new CollectorBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDERS:
                return new OrdersBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case DELIVERY:
                return new DeliveryBOImpl();
            case TEATYPE:
                return new TeaTypeBOImpl();
            case PRICE:
                return new PriceBOImpl();
            default:
                return null;
        }
    }

}


