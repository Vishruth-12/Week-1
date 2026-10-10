import java.util.Scanner;

public class WarehouseInventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        for (int value : sectionA) totalA += value;
        for (int value : sectionB) totalB += value;
        System.out.print("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: ");
        System.out.print(totalA == totalB ? "Balanced" : "Not Balanced");

        int max = Integer.MIN_VALUE, section = 0, index = -1;
        for (int i = 0; i < sectionA.length; i++) if (sectionA[i] > max) { max = sectionA[i]; section = 1; index = i; }
        for (int i = 0; i < sectionB.length; i++) if (sectionB[i] > max) { max = sectionB[i]; section = 2; index = i; }
        if (index >= 0) System.out.println(" | Highest Quantity: " + max + " (Section " + (section == 1 ? "A" : "B") + ", Item " + (index + 1) + ")");
        else System.out.println(" | No items found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of item categories: "); int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        System.out.println("Enter quantities for Section A:"); for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter quantities for Section B:"); for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        analyzeInventory(a, b);
        sc.close();
    }
}