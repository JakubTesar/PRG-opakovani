import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarsService {
    private ArrayList<Car> carsList = new ArrayList<>();

    public void add(Car car){
        carsList.add(car);
    }
    public void remove(String id){
        carsList = (ArrayList<Car>) carsList.stream()
                .filter(i -> !i.getId().equals(id)).collect(Collectors.toList());
    }
    public ArrayList<Car> getAll(){
        return carsList;
    }

    public void setCarsList(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }
}
