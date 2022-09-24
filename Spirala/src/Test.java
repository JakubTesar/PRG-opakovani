import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dir = 0;
        int length = 0;
        int counter = 0;
        int[][] arr = new int[Integer.parseInt(sc.nextLine())][Integer.parseInt(sc.nextLine())];
        int l = arr.length;
        for (int j = 0; j < l; j++) {
            arr[0][j] = counter;
            counter++;
        }
        counter--;
        for (int k = 0; k < l; k++) {
            arr[k][l - 1] = counter;
            counter++;
        }
        for (int i = l - 2; i >= 0; i--) {
            arr[l - 1][i] = counter;
            counter++;
        }
        for (int a = l - 2; a >= 1; a--) {
            arr[a][0] = counter;
            counter++;
        }
        int d = 0; // ->
        //int d = 1; // down
        //int d = 2; // <-
        //int d = 3; // up
        int r = 1;
        int s = 1;
        while (counter != (l * l)-1) {
            if (d == 0) {
                if (arr[r][s - 1] == counter - 1 && arr[r][s] == 0) {
                    arr[r][s] = counter;
                    counter++;
                    s++;
                } else {
                    d = 1;
                    r++;
                    s--;
                }
            }
            if (d == 1) {
                if (arr[r - 1][s] == counter - 1 && arr[r][s] == 0) {
                    arr[r][s] = counter;
                    counter++;
                    r++;
                } else {
                    d = 2;
                    r--;
                    s--;
                }
            }
            if (d == 2) {

                if (arr[r][s + 1] == counter - 1 && arr[r][s] == 0) {
                    arr[r][s] = counter;
                    counter++;
                    s--;
                } else {
                    r--;
                    s++;
                    d = 3;
                }
            }

            if (d == 3) {
                System.out.println(r+" "+s);
                if (arr[r+1][s] == counter - 1 && arr[r][s] == 0) {
                    arr[r][s] = counter;
                    counter++;
                    r--;
                } else {
                    d=0;
                }
            }
        }


        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}


