import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService();
        Kurz PRG = new Kurz("PRG", "Nejlepší kurz", courseRepository.loadCourse());
        courseService.addPost(PRG);
        Scanner sc = new Scanner(System.in);
        String programEnd = "ano";
        int choise = 0;
        while (programEnd.equals("ano")) {
            System.out.println("-----Zdravím-----");
            System.out.println("-----Přidání oznameni (1)-----");
            System.out.println("-----Smazaní oznameni (2)-----");
            choise = Integer.parseInt(sc.nextLine());
            if (choise == 1) {
                String name ="";
                String description ="";
                courseService.addPost(PRG);
                System.out.println("Zadejte název kurzu do kterého chcete přidat oznameni");
                name = sc.nextLine();
                System.out.println("Zadejte popis kurzu");
                description = sc.nextLine();

                courseRepository.saveCourse(name,description, PRG.getList());
                System.out.println("-----Kurz byl přidán-----");
                courseService.addPost(PRG);
                System.out.println("");
                courseRepository.loadCourse();
                System.out.println("");

            }
            if (choise == 2) {
                String name ="";
                String description ="";

                System.out.println("Zadejte název kurzu ze kterého chcete smazat oznameni");
                name = sc.nextLine();
                System.out.println("Zadejte popis kurzu");
                description = sc.nextLine();
                String id = "";
                System.out.println("Zadejte ID oznameni");
                id = sc.nextLine();
                courseService.removePost(id, PRG);
                courseRepository.saveCourse(name,description, PRG.getList());
                System.out.println("Oznameni bylo smazáno");
                courseRepository.loadCourse();
            }
            System.out.println("Chcete pokračovat? ano / ne");
            programEnd = sc.nextLine();
        }
        System.out.println("-----KONEC-----");
    }
}
