import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseService {
    public void addPost(Kurz kurz) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Add oznameni");
        System.out.println("2 - Add material");
        System.out.println("3 - Add úkol");
        int choise = Integer.parseInt(sc.nextLine());

        if (choise == 1) {
            System.out.println("Zadejte title");
            System.out.println("Zadejte viditělnost (true/false)");
            System.out.println("Zadejte Obsah");
            Oznameni oznameni = new Oznameni(sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
            kurz.getList().add(oznameni);
        }
        if (choise == 2) {
            System.out.println("Zadejte title");
            System.out.println("Zadejte viditělnost (true/false)");
            System.out.println("Zadejte Url");
            Material material = new Material(sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
            kurz.getList().add(material);
        }
        if (choise == 3) {
            System.out.println("Zadejte title");
            System.out.println("Zadejte viditělnost (true/false)");
            System.out.println("Zadejte Datum");
            Ukol ukol = new Ukol(sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
            kurz.getList().add(ukol);
        }
    }
    public void removePost(String id, Kurz kurz) {
        kurz.setList((ArrayList<EpicClass>) kurz.getList().stream()
                .filter(i -> !i.getId().equals(i.getId())).collect(Collectors.toList())) ;
    }

    ;
}
