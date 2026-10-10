import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    static void classifyWordLengths(String review) {
        int shortWords = 0, mediumWords = 0, longWords = 0;
        String trimmed = review.trim();
        if (!trimmed.isEmpty()) {
            String[] words = trimmed.split("\\s+");
            for (String word : words) {
                int length = word.replaceAll("[^\\p{L}\\p{N}]", "").length();
                if (length >= 1 && length <= 4) shortWords++;
                else if (length <= 8 && length >= 5) mediumWords++;
                else if (length >= 9) longWords++;
            }
        }
        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie review: ");
        classifyWordLengths(sc.nextLine());
        sc.close();
    }
}