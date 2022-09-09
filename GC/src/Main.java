import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService();
        Kurz PRG = new Kurz("PRG", "Nejlepší kurz", courseRepository.loadCourse());
        Scanner sc = new Scanner(System.in);
        String programEnd = "ano";
        int choise = 0;
        while (programEnd.equals("ano")) {
            System.out.println("-----Zdravím-----");
            System.out.println("-----Přidání oznameni (1)-----");
            System.out.println("-----Smazaní oznameni (2)-----");
            choise = Integer.parseInt(sc.nextLine());
            if (choise == 1) {
                String name = "";
                String description = "";
                System.out.println("Zadejte název kurzu do kterého chcete přidat oznameni");
                name = sc.nextLine();
                System.out.println("Zadejte popis kurzu");
                description = sc.nextLine();
                courseRepository.saveCourse(name, description, PRG.getList());
                System.out.println("-----Kurz byl přidán-----");
                System.out.println("1 - Add oznameni");
                System.out.println("2 - Add material");
                System.out.println("3 - Add ukol");
                System.out.println("");
                int choise2 = Integer.parseInt(sc.nextLine());
                if (choise2 == 1) {
                    System.out.println("Zadejte title");
                    System.out.println("Zadejte viditělnost (true/false)");
                    System.out.println("Zadejte Obsah");
                    Oznameni oznameni = new Oznameni(sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
                    courseService.addPost(PRG, oznameni);
                }
                if (choise2 == 2) {
                    System.out.println("Zadejte title");
                    System.out.println("Zadejte viditělnost (true/false)");
                    System.out.println("Zadejte Url");
                    Material material = new Material(sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
                    courseService.addPost(PRG, material);

                }
                if (choise2 == 3) {
                    System.out.println("Zadejte title");
                    System.out.println("Zadejte viditělnost (true/false)");
                    System.out.println("Zadejte Datum");
                    Ukol ukol = new Ukol(sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
                    courseService.addPost(PRG, ukol);

                }
                System.out.println("");
                courseRepository.loadCourse();
                System.out.println("");

            }
            if (choise == 2) {
                String name = "";
                String description = "";

                System.out.println("Zadejte název kurzu ze kterého chcete smazat oznameni");
                name = sc.nextLine();
                System.out.println("Zadejte popis kurzu");
                description = sc.nextLine();
                String id = "";
                System.out.println("Zadejte ID oznameni");
                id = sc.nextLine();
                courseService.removePost(id, PRG);
                courseRepository.saveCourse(name, description, PRG.getList());
                System.out.println("Oznameni bylo smazáno");
                courseRepository.loadCourse();
            }
            System.out.println("Chcete pokračovat? ano / ne");
            programEnd = sc.nextLine();
        }
        System.out.println("-----KONEC-----");
    }
}
