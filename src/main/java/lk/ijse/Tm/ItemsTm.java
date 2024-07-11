package lk.ijse.Tm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsTm {
    private  String I_ID;
    private  String Description;
    private  String  Price;
    public ItemsTm() {
    }

    public ItemsTm(String i_ID, String description, String price) {
        this.I_ID = i_ID;
        this.Description = description;
        this.Price = price;

    }

    public String getId() {return I_ID;}

    public void setId(String id) {this.I_ID = id;}

    public String getDescription() {return Description;}

    public void setDescription(String description) {this.Description = description;}

    public String getPrice() {return Price;}

    public void setPrice(String price) {this.Price = price;}



    @Override
    public String toString() {
        return "ItemTm{" +
                "i_id='" + I_ID + '\'' +
                ", description='" + Description + '\'' +
                ", price='" + Price + '\'' +

                '}';
    }
}










