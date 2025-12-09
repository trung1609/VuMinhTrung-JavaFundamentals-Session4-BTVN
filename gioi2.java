package Session4;

import java.util.Scanner;

public class gioi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu mang: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Phan tu thu %d: ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mang truoc khi sap xep: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] % 2 != 0 && arr[j + 1] % 2 == 0) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.print("\nMang sau khi sap xep: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
