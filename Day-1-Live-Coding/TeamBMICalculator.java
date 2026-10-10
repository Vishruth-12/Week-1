import java.util.Scanner;

public class TeamBMICalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%d | %.2f | %.2f | %.2f | %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of people: ");
        int n = sc.nextInt();
        if (n <= 0) { System.out.println("Number of people must be positive."); sc.close(); return; }
        double[] heights = new double[n], weights = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " height in meters: "); heights[i] = sc.nextDouble();
            while (heights[i] <= 0) { System.out.print("Height must be positive. Enter again: "); heights[i] = sc.nextDouble(); }
            System.out.print("Person " + (i + 1) + " weight in kg: "); weights[i] = sc.nextDouble();
            while (weights[i] <= 0) { System.out.print("Weight must be positive. Enter again: "); weights[i] = sc.nextDouble(); }
        }
        printWellnessReport(heights, weights);
        sc.close();
    }
}