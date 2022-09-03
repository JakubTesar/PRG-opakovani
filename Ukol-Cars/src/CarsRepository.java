import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarsRepository {

    public ArrayList<Car> loadCars() {
        ArrayList<Car> carsList = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\NTBK\\Desktop\\GitHub\\PRG-opakovani\\Ukol-Cars\\src\\txt.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        int i;
        try {
            while ((i = br.read()) != -1) {
                System.out.print((char) i);
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
                writer = new FileWriter("C:\\Users\\NTBK\\Desktop\\GitHub\\PRG-opakovani\\Ukol-Cars\\src\\txt.txt");
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
