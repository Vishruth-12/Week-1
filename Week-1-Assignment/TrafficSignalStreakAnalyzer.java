import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) { System.out.println("No signal readings found"); return; }
        char bestColor = signalLog.charAt(0), currentColor = signalLog.charAt(0);
        int bestLength = 1, currentLength = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            char current = signalLog.charAt(i);
            if (current == currentColor) currentLength++;
            else { currentColor = current; currentLength = 1; }
            if (currentLength > bestLength) { bestLength = currentLength; bestColor = currentColor; }
        }
        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter signal log (R/Y/G): ");
        findLongestStreak(sc.nextLine().trim());
        sc.close();
    }
}