package Session4;

import java.util.Scanner;

public class xuatsac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());
        boolean isSort = false;
        boolean isSortAsc = false;
        float[] score = new float[n];
        for (int i = 0; i < score.length; i++) {
            System.out.printf("Nhap diem sinh vien thu %d: ", i + 1);
            score[i] = Float.parseFloat(sc.nextLine());
        }
        do {
            System.out.println("--- QUAN LY DIEM SINH VIEN ---");
            System.out.println("1. Xem tat ca diem");
            System.out.println("2. Sap xep diem");
            System.out.println("3. Tim kiem diem");
            System.out.println("4. Thong ke diem");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1. Xem tat ca diem");
                    System.out.printf("Diem cua %d sinh vien: ", n);
                    for (int i = 0; i < score.length; i++) {
                        System.out.printf("%.2f ", score[i]);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Chon cach sap xep:");
                    System.out.println("1. Tang dan");
                    System.out.println("2. Giam dan");
                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            for (int i = 0; i < score.length; i++) {
                                for (int j = 0; j < score.length - i - 1; j++) {
                                    if (score[j] > score[j + 1]) {
                                        float tmp = score[j];
                                        score[j] = score[j + 1];
                                        score[j + 1] = tmp;
                                    }
                                }
                            }
                            isSortAsc = true;
                            isSort = true;
                            System.out.println("Da sap xep tang dan");
                            break;
                        case 2:
                            for (int i = 0; i < score.length; i++) {
                                for (int j = 0; j < score.length - i - 1; j++) {
                                    if (score[j] < score[j + 1]) {
                                        float tmp = score[j];
                                        score[j] = score[j + 1];
                                        score[j + 1] = tmp;
                                    }
                                }
                            }
                            isSortAsc = false;
                            isSort = true;
                            System.out.println("Da sap xep giam dan");
                            break;
                        default:
                            System.err.println("Vui long chon 1-2");
                    }
                    break;
                case 3:
                    System.out.println("3. Tim kiem diem");
                    System.out.print("Nhap diem can tim: ");
                    int searchValue = Integer.parseInt(sc.nextLine());
                    boolean isFound = false;
                    //Tim kiem tuyen tinh
                    for (int i = 0; i < score.length; i++) {
                        if (score[i] == searchValue) {
                            System.out.printf("Tim kiem tuyen tinh: Tim thay tai vi tri %d\n", i);
                        }
                    }
                    //Tim kiem nhi phan
                    if (isSort) {
                        int left = 0;
                        int right = score.length - 1;
                        int mid = -1;
                        if (isSortAsc) {
                            while (left <= right) {
                                mid = (left + right) / 2;
                                if (score[mid] == searchValue) {
                                    isFound = true;
                                    break;
                                } else if (score[mid] > searchValue) {
                                    right = mid - 1;
                                } else {
                                    left = mid + 1;
                                }
                            }
                            if (isFound) {
                                System.out.printf("Tim kiem nhi phan (mang tang dan): Tim thay tai vi tri %d\n", mid);
                            } else {
                                System.out.println("Khong tim thay diem");
                            }
                        } else {
                            while (left <= right) {
                                mid = (left + right) / 2;
                                if (score[mid] == searchValue) {
                                    isFound = true;
                                    break;
                                } else if (score[mid] > searchValue) {
                                    left = mid + 1;
                                } else {
                                    right = mid - 1;
                                }
                            }
                            if (isFound) {
                                System.out.printf("Tim kiem nhi phan (mang giam dan): Tim thay tai vi tri %d\n", mid);
                            } else {
                                System.out.println("Khong tim thay diem");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("4. Thong ke diem");
                    float avg;
                    float sum = 0;
                    int count = 0;
                    for (int i = 0; i < score.length; i++) {
                        sum += score[i];
                        if (score[i] >= 5) {
                            count++;
                        }
                    }
                    avg = sum / score.length;
                    System.out.println("Diem trung binh: " + avg);
                    float min = score[0];
                    float max = score[0];
                    for (int i = 1; i < score.length; i++) {
                        if (score[i] < min) {
                            min = score[i];
                        }
                        if (score[i] > max) {
                            max = score[i];
                        }
                    }
                    System.out.println("Diem cao nhat: " + max);
                    System.out.println("Diem thap nhat: " + min);
                    System.out.println("So sinh vien dat diem tren trung binh: " + count);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-5");
            }
        } while (true);
    }
}
