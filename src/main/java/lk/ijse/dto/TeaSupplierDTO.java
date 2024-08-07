package lk.ijse.dto;

import java.io.Serializable;
public class TeaSupplierDTO implements Serializable {

        private String TS_ID;
        private String Name;
        private String Address;
        private String Contact;

    public TeaSupplierDTO() {
    }

    public TeaSupplierDTO(String ts_id, String name, String address, String contact) {
        this.TS_ID = ts_id;
        this.Name = name;
        this.Address = address;
        this.Contact = contact;
    }

        public String getId () {return TS_ID; }

        public void setId (String id){this.TS_ID = id; }

        public String getName () {return Name; }

        public void setName (String name){this.Name = name; }

        public String getAddress () {return Address; }

        public void setAddress (String address){this.Address = address; }

        public String getContact () {return Contact; }

        public void setContact (String contact){this.Contact = contact; }

        @Override
        public String toString () {
        return "TeaSupplierDTO{" +
                "id='" + TS_ID + '\'' +
                ", name='" + Name + '\'' +
                ", address='" + Address + '\'' +
                ", tel='" + Contact + '\'' +
                '}';
    }
    }




