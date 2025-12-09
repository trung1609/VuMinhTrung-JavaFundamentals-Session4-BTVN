package Session4;

import java.util.Scanner;

public class gioi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cua mang: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Phan tu thu %d: ", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[minPos]) {
                    minPos = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = tmp;
        }
        System.out.println("Mang sau khi sap xep giam dan:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\nNhap so can tim: ");
        int searchValue = Integer.parseInt(sc.nextLine());
        //Tim kiem tuyen tinh
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                System.out.printf("Tim kiem tuyen tinh: So %d co tai vi tri %d\n", searchValue, i);
            }
        }
        //Tim kiem nhi phan
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        boolean isFound = false;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == searchValue) {
                isFound = true;
                break;
            } else if (arr[mid] > searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (isFound) {
            System.out.printf("Tim kiem nhi phan: So %d co tai vi tri %d\n", searchValue, mid);
        } else {
            System.out.println("Khong tim thay gia tri");
        }
    }
}
