import java.io.*;
import java.util.ArrayList;

public class CourseRepository {
    public ArrayList<EpicClass> loadCourse() {
        ArrayList<EpicClass> list = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(".\\Course.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String strCurrentLine;
        try {
            while ((strCurrentLine = br.readLine()) != null) {
                String[] splitS = strCurrentLine.split(";");

                EpicClass temp;
                switch (splitS[0]) {
                    case "Oznameni" -> temp = new Oznameni();
                    case "Material" -> temp = new Material();
                    case "Ukol" -> temp = new Ukol();
                    default -> temp = new EpicClass();
                }

                list.add(temp);
                System.out.println(strCurrentLine);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void saveCourse(String name, String description, ArrayList<EpicClass> list) {
        try {
            FileWriter writer = null;
            try {
                writer = new FileWriter(".\\Course.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter buffer = new BufferedWriter(writer);
            for (EpicClass object : list) {
                //(car.getId() + ";" + car.getCarBrand() + ";" + car.getTotalKms() + ";" + car.getPrice())
                if (object instanceof Oznameni) {
                    buffer.write("Oznameni;" + ((Oznameni) object).getObsah() + ";" + object.getTimeAdd()
                            + ";" + object.getTitle() + ";" + object.isVisibleForStudents());
                    buffer.newLine();
                } else if (object instanceof Material) {
                    buffer.write("Material;" + ((Material) object).getUrl() + ";" + object.getTimeAdd()
                            + ";" + object.getTitle() + ";" + object.isVisibleForStudents());
                    buffer.newLine();
                } else if (object instanceof Ukol) {
                    buffer.write("Ukol;" + ((Ukol) object).getFinishTime() + ";" + object.getTimeAdd()
                            + ";" + object.getTitle() + ";" + object.isVisibleForStudents());
                    buffer.newLine();
                }
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
