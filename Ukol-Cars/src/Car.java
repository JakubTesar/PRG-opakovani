import java.util.UUID;

public class Car {
    private String id = UUID.randomUUID().toString();
    private String CarBrand;
    private int TotalKms;
    private int Price;

    public Car(String carBrand, int totalKms, int price) {
        CarBrand = carBrand;
        TotalKms = totalKms;
        Price = price;
    }

    public String getId() {
        return id;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public int getTotalKms() {
        return TotalKms;
    }

    public int getPrice() {
        return Price;
    }
}
