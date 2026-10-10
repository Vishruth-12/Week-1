import java.util.Scanner;

public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i]; chars[i] = chars[chars.length - 1 - i]; chars[chars.length - 1 - i] = temp;
        }
        return text.equals(new String(chars));
    }

    static String label(boolean result) { return result ? "Palindrome" : "Not Palindrome"; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Iterative: " + label(isPalindromeIterative(text)));
        System.out.println("Recursive: " + label(isPalindromeRecursive(text)));
        System.out.println("Array Reversal: " + label(isPalindromeArrayReversal(text)));
        sc.close();
    }
}