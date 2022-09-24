import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dir = 0;
        int length = 0;
        int counter = 0;
        int counter2 = 6;
        int[][] arr = new int[Integer.parseInt(sc.nextLine())][Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < arr.length; i++) {
            if (dir == 1) {
                arr[i][arr.length - 1] = counter;
                counter++;
                if (counter == (arr.length + arr.length)-2) {
                    dir = 2;
                }
            }
            for (int k = arr.length - 1; k >= 0; k--) {
                if (dir == 2) {
                    arr[arr.length-1][k] = counter2;
                    counter2++;
                    if (counter2 >= (arr.length * 3)) {
                        dir = 3;
                    }
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (dir == 0) {
                    arr[i][j] = counter;
                    counter++;
                    if (counter >= (arr.length)) {
                        dir = 1;
                    }
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
