import java.util.Scanner;

public class TypingSpeedAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        int total = Math.max(original.length(), typed.length());
        int matched = 0, firstMismatch = -1;
        for (int i = 0; i < total; i++) {
            if (i < original.length() && i < typed.length() && original.charAt(i) == typed.charAt(i)) matched++;
            else if (firstMismatch == -1) firstMismatch = i;
        }
        double accuracy = total == 0 ? 100.0 : matched * 100.0 / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);
        if (firstMismatch == -1) System.out.println(" | No Mismatches");
        else {
            System.out.print(" | First Mismatch at position " + (firstMismatch + 1) + " (");
            if (firstMismatch < original.length()) System.out.print("'" + original.charAt(firstMismatch) + "'"); else System.out.print("end of original");
            System.out.print(" vs ");
            if (firstMismatch < typed.length()) System.out.print("'" + typed.charAt(firstMismatch) + "'"); else System.out.print("end of typed text");
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Original passage: "); String original = sc.nextLine();
        System.out.print("Typed passage: "); String typed = sc.nextLine();
        checkTypingAccuracy(original, typed);
        sc.close();
    }
}