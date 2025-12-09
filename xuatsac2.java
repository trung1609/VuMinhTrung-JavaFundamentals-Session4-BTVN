package Session4;

import java.util.Scanner;

public class xuatsac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        int n = Integer.parseInt(sc.nextLine());
        float[] salaries = new float[n];
        int k = 0;
        boolean isFound = false;
        boolean isSort = false;
        boolean isSortAsc = false;
        do {
            System.out.printf("Nhap luong nhan vien %d: ", k + 1);
            salaries[k] = Float.parseFloat(sc.nextLine());
            if (salaries[k] <= 0) {
                System.err.print("\nVui long nhap luong lon hon 0.Nhap lai: ");
                continue;
            }
            k++;
        } while (k < salaries.length);

        do {
            System.out.println("--- QUAN LY LUONG NHAN VIEN ---");
            System.out.println("1. Xem danh sach luong");
            System.out.println("2. Sap xep luong");
            System.out.println("3. Tim kiem luong cu the");
            System.out.println("4. Thong ke luong");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sach luong nhan vien: ");
                    for (int i = 0; i < salaries.length; i++) {
                        System.out.printf("Nhan vien %d: %.1f \n", i + 1, salaries[i]);
                    }
                    break;
                case 2:
                    System.out.println("Chon cach sap xep:");
                    System.out.println("1. Tang dan");
                    System.out.println("2. Giam dan");
                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            for (int i = 0; i < salaries.length - 1; i++) {
                                int minPos = i;
                                for (int j = i + 1; j < salaries.length; j++) {
                                    if (salaries[j] < salaries[minPos]) {
                                        minPos = j;
                                    }
                                }
                                float tmp = salaries[i];
                                salaries[i] = salaries[minPos];
                                salaries[minPos] = tmp;
                            }
                            isSort = true;
                            isSortAsc = true;
                            System.out.println("Da sap xep luong tang dan.");
                            break;
                        case 2:
                            for (int i = 0; i < salaries.length - 1; i++) {
                                for (int j = 0; j < salaries.length - i - 1; j++) {
                                    if (salaries[j] < salaries[j + 1]) {
                                        float tmp = salaries[j];
                                        salaries[j] = salaries[j + 1];
                                        salaries[j + 1] = tmp;
                                    }
                                }
                            }
                            isSort = true;
                            isSortAsc = false;
                            System.out.println("Da sap xep luong giam dan.");
                            break;
                        default:
                            System.err.println("Vui long chon 1 hoac 2.");
                    }
                    break;
                case 3:
                    System.out.print("Nhap luong can tim: ");
                    int searchValue = Integer.parseInt(sc.nextLine());
                    //Linear Search
                    for (int i = 0; i < salaries.length; i++) {
                        if (salaries[i] == searchValue) {
                            System.out.printf("Linear Search: Tim thay tai vi tri %d.\n", i);
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        System.out.println("Linear Search: Khong tim thay luong can tim.");
                    }

                    //Binary Search
                    int left = 0;
                    int right = salaries.length - 1;
                    int mid = -1;
                    if (isSort) {
                        if (isSortAsc) {
                            while (left <= right) {
                                mid = (left + right) / 2;
                                if (salaries[mid] == searchValue) {
                                    isFound = true;
                                    break;
                                } else if (salaries[mid] > searchValue) {
                                    right = mid - 1;
                                } else {
                                    left = mid + 1;
                                }
                            }
                            if (isFound) {
                                System.out.printf("Binary Search(mang tang dan): Tim thay tai vi tri %d.\n", mid);
                            } else {
                                System.out.println("Binary Search(mang tang dan): Khong tim thay luong can tim.");
                            }
                        } else {
                            while (left <= right) {
                                mid = (left + right) / 2;
                                if (salaries[mid] == searchValue) {
                                    isFound = true;
                                    break;
                                } else if (salaries[mid] > searchValue) {
                                    left = mid + 1;
                                } else {
                                    right = mid - 1;
                                }
                            }
                            if (isFound) {
                                System.out.printf("Binary Search(mang giam dan): Tim thay tai vi tri %d.\n", mid);
                            } else {
                                System.out.println("Binary Search(mang giam dan): Khong tim thay luong can tim.");
                            }
                        }
                    }
                    break;
                case 4:
                    float sum = 0;
                    float min = salaries[0];
                    float max = salaries[0];
                    int count = 0;
                    for (int i = 0; i < salaries.length; i++) {
                        sum += salaries[i];
                        if (min > salaries[i]) {
                            min = salaries[i];
                        }
                        if (max < salaries[i]) {
                            max = salaries[i];
                        }
                        if (salaries[i] >= 5000) {
                            count++;
                        }
                    }
                    System.out.printf("Tong luong: %.1f\n", sum);
                    System.out.printf("Luong trung binh: %.1f\n", (sum / salaries.length));
                    System.out.printf("Luong cao nhat: %.1f\n", max);
                    System.out.printf("Luong thap nhat: %.1f\n", min);
                    System.out.printf("So nhan vien co luong tren trung binh: %d\n", count);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-5");
            }
        } while (true);
    }
}
