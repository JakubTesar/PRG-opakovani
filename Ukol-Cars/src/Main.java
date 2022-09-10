import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarsService carsService = new CarsService();
        CarsRepository carsRepository = new CarsRepository();
        String programEnd = "ano";
        int moznost = 0;
        carsService.setCarsList(carsRepository.loadCars());
        while (programEnd.equals("ano")) {
            System.out.println("-----Zdravím-----");
            System.out.println("-----Přidání auta (1)-----");
            System.out.println("-----Smazaní auta (2)-----");
            System.out.println("-----Zobrazení seznamu aut (3)-----");
            moznost = Integer.parseInt(sc.nextLine());
            if (moznost == 1) {
                String brand = "";
                int totalKms = 0;
                int price = 0;
                System.out.println("-----Zadejte značku auta-----");
                brand = sc.nextLine();
                System.out.println("-----Zadejte naježděné kilometry auta-----");
                totalKms = Integer.parseInt(sc.nextLine());
                System.out.println("-----Zadejte cenu auta-----");
                price = Integer.parseInt(sc.nextLine());
                Car car = new Car(brand, totalKms, price);
                carsService.add(car);
                carsRepository.saveCars(carsService.getAll());
                System.out.println("-----Auto bylo přidáno-----");
                System.out.println(car.getCarBrand() + " " + car.getPrice() + " " + car.getId());
            }
            if (moznost == 2) {
                String id = "";
                System.out.println("Zadejte ID auta");
                id = sc.nextLine();
                carsService.remove(id);
                carsRepository.saveCars(carsService.getAll());
                System.out.println("Auto bylo smazáno");
            }
            if (moznost == 3) {
                if (carsRepository.loadCars().size() <= 0) {
                    System.out.println("Nejsou zde žádná auta");
                } else {
                    for (Car car: carsService.getAll()) {
                        System.out.println(car.getCarBrand() + " " + car.getPrice() + " " + car.getId());
                    }
                }
            }
            System.out.println("Chcete pokračovat? ano / ne");
            programEnd = sc.nextLine();
        }
        System.out.println("-----KONEC-----");
    }
}
