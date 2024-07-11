package lk.ijse.dto;

public class CustomDTO {
    //TeaSupplier
    private String TS_ID;
    private String Name;
    private String Address;
    private String Contact;

    //Collector
    private  String Collect_ID;
    private  String Name;
    private  String Address;
    private  int ContactNo;

    //Employee
    private  String EMP_ID;
    private  String  Name;
    private  String Salary;
    private  String Date;

    //Delivery
    private  String Code;
    private  String Price;
    private  String Date;
    private  String Address;

    //Item
    private  String I_ID;
    private  String Description;
    private  String  Price;

    //Orders
    private  String OR_ID;
    private  String Date;
    private  String Address;
    private  String Quantity;

    //Payment
    private  String Payment_ID;
    private  String Payment_method;
    private  String Address;

    //Price
    private  String   Category;
    private  String  Duration;
    private  String  KG_Price;

    //TeaType
    private  String Tea_ID;
    private  String Price;
    private  String Tea_Category;


    //TSCollectDetails
    private String Collect_ID;
    private String TS_ID;
    private int Amount_of_the_tea;

    //CollectEmpDetails
    private String Collect_ID;
    private String Emp_ID;
    private int Date;


    //OrderItemDetails
    private String OR_ID;
    private String I_ID;
    private int Date;

    public CustomDTO() {
        this.Collect_ID=Collect_ID;
        this.TS_ID=TS_ID;
        this.EMP_ID=emp_id;
        this.I_ID=i_id;
        this.OR_ID=or_id;
        this.Payment_ID=payment_id;
        this.Code=code;
        this.Tea_ID=teaid;
    this.Description=description;
    this.Quantity=quantity;
    this.Payment_method=PAYMETHOD,CATEGORY,PRICE,KGPRICE,DURATION
    }






          //TeaSupplier
    public String getId () {return TS_ID; }

    public void setId (String id){this.TS_ID = id; }

    public String getName () {return Name; }

    public void setName (String name){this.Name = name; }

    public String getAddress () {return Address; }

    public void setAddress (String address){this.Address = address; }

    public String getContact () {return Contact; }

    public void setContact (String contact){this.Contact = contact; }

                     //Collector
    public String getId() {return Collect_ID; }

    public void setId(String id) {this.Collect_ID = id;}

    public String getName() {return Name;}

    public void setName(String name) {this.Name = name;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {this.Address = address;}

    public String getContact() {return ContactNo;}

    public void setContact(String contact) {this.ContactNo = contact;}

             //Employee
    public String getId() {return EMP_ID; }

    public void setId(String id) {this.EMP_ID = id; }

    public String getName() {return Name; }

    public void setName(String name) {this.Name = name; }

    public String getSalary() {return Salary; }

    public void setSalary(String salary) {this.Salary = salary; }

    public String getDate() {return Date; }

    public void setDate(String date) {this.Date = date; }

             //Delivery
    public String getCode() {return Code;}

    public void setCode(String code) {this.Code = code;}

    public String getPrice() {return Price;}

    public void setPrice(String price) {this.Price = price;}

    public String getDate() {return Date;}

    public void setDate(String date) {this.Address = date;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {this.Address = address;}

                 //Item
    public String getId() {return I_ID;}

    public void setId(String id) {this.I_ID = id;}

    public String getDescription() {return Description;}

    public void setDescription(String description) {this.Description = description;}

    public String getPrice() {return Price;}

    public void setPrice(String price) {this.Price = price;}


            //Orders
    public String getId() {return OR_ID;}

    public void setId(String id) {this.OR_ID = id;}

    public String getDate() {return Date;}

    public void setDate(String date) {this.Date = date;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {this.Address = address;}

    public String getQuantity() {return Quantity;}

    public void setQuantity(String quantity) {this.Quantity = quantity;}


          //Payment
    public String getId() {return Payment_ID;}

    public void setId(String id) {this.Payment_ID = id;}

    public String getPayment_method() {return Payment_method;}

    public void setPayment_method(String payment_method) {this.Payment_method = payment_method;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {this.Address = address;}


           //Price
    public String getCategory() {return Category;}

    public void setCategory(String category) {this.Category = category;}

    public String getDuration() {return Duration;}

    public void setDuration(String duration) {this.Duration = duration;}

    public String getPrice() {return KG_Price;}

    public void setPrice(String kg_price) {this.KG_Price = kg_price;}


          //TeaType

    public String getId() {return Tea_ID;}

    public void setId(String id) {this.Tea_ID = id;}

    public String getPrice() {return Price;}

    public void setPrice(String price) {this.Price = price;}

    public String getTea_Category() {return Tea_Category;}

    public void setTea_Category(String tea_Category) {this.Tea_Category = tea_Category;}


               //TSCollectDetails
    public String getCollect_ID() {
                   return Collect_ID;
               }

    public void setCollect_ID(String collect_ID) {this.Collect_ID = collect_ID;}

    public String getTS_ID() {
        return TS_ID;
    }

    public void setTS_ID(String ts_id) {
        this.TS_ID = ts_id;
    }

    public int getAmount_of_the_tea() {
        return Amount_of_the_tea;
    }

    public void setAmount_of_the_tea(int amount_of_the_tea) {
        this.Amount_of_the_tea= amount_of_the_tea;
    }


          //CollectEmpDetails
    public String getCollect_ID() {
              return Collect_ID;
          }

    public void setCollect_ID(String collect_ID) {this.Collect_ID = collect_ID;
    }

    public String getEmp_ID() {
        return Emp_ID;
    }

    public void setEmp_ID(String emp_id) {
        this.Emp_ID = emp_id;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        this.Date= date;
    }



              //OrderItemDetails
    public String getOR_ID() {
                  return OR_ID;
              }

    public void setOR_ID(String or_id) {this.OR_ID = or_id;}

    public String getI_ID() {
        return I_ID;
    }

    public void setI_ID(String i_ID) {
        this.I_ID = i_ID;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        this.Date= date;
    }





}
