package Session4;

import java.util.Scanner;

public class kha2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so hang cua mang: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap so cot cua mang: ");
        int col = Integer.parseInt(sc.nextLine());
        int[][] arr2D = new int[row][col];
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.printf("Phan tu [%d][%d]: ", i, j);
                arr2D[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] % 2 == 0) {
                    sumEven += arr2D[i][j];
                } else {
                    sumOdd += arr2D[i][j];
                }
            }
        }
        System.out.println("Tong cac so chan: " + sumEven);
        System.out.println("Tong cac so le: " + sumOdd);
    }
}
