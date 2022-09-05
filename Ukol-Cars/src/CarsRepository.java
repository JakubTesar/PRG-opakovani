import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarsRepository {

    public ArrayList<Car> loadCars() {
        ArrayList<Car> carsList = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(".\\Cars.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String strCurrentLine;
        try {
            while ((strCurrentLine = br.readLine()) != null) {
                String[] carS = strCurrentLine.split(";");
                Car car1 = new Car(carS[1],Integer.parseInt(carS[2]),Integer.parseInt(carS[3]));
                System.out.println(strCurrentLine);
                carsList.add(car1);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carsList;
    }

    public void saveCars(ArrayList<Car> cars) {
        try {
            FileWriter writer = null;
            try {
                writer = new FileWriter(".\\Cars.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter buffer = new BufferedWriter(writer);
            for (Car car : cars) {
                buffer.write((car.getId() + ";" + car.getCarBrand() + ";" + car.getTotalKms() + ";" + car.getPrice()));
                buffer.newLine();
            }

            buffer.close();
            System.out.println("");
            System.out.println("Uloženo");
            System.out.println("");

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
