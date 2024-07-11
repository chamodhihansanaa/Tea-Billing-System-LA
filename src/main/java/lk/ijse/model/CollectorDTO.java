package lk.ijse.model;

import java.io.Serializable;

public class CollectorDTO implements Serializable {
    private  String Collect_ID;
    private  String Name;
    private  String Address;
    private  String ContactNo;
    public CollectorDTO() {
    }

    public CollectorDTO(String collect_ID, String name, String address, String contact) {
        this.Collect_ID = collect_ID;
        this.Name = name;
        this.Address = address;
        this.ContactNo = contact;
    }

    public String getId() {return Collect_ID; }

    public void setId(String id) {this.Collect_ID = id;}

    public String getName() {return Name;}

    public void setName(String name) {this.Name = name;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {this.Address = address;}

    public String getContact() {return ContactNo;}

    public void setContact(String contact) {this.ContactNo = contact;}

    @Override
    public String toString() {
        return "CollectorDTO{" +
                "collect_id='" + Collect_ID + '\'' +
                ", name='" + Name + '\'' +
                ", address='" + Address + '\'' +
                ", contactno='" + ContactNo + '\'' +
                '}';
    }
}






