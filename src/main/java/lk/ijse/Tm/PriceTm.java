package lk.ijse.Tm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceTm {
    private  String   Category;
    private  String  Duration;
    private  String  KG_Price;
    public PriceTm() {
    }

    public PriceTm(String category, String duration, String kg_price) {
        this.Category = category;
        this.Duration = duration;
        this.KG_Price = kg_price;

    }

    public String getCategory() {

        return Category;
    }

    public void setCategory(String category) {

        this.Category = category;
    }

    public String getDuration() {

        return Duration;
    }

    public void setDuration(String duration) {

        this.Duration = duration;
    }

    public String getPrice() {

        return KG_Price;
    }

    public void setPrice(String kg_price) {

        this.KG_Price = kg_price;
    }



    @Override
    public String toString() {
        return "PriceTm{" +
                "category='" + Category + '\'' +
                ", duration='" + Duration + '\'' +
                ", price='" + KG_Price + '\'' +

                '}';
    }
}













