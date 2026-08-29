package string.class_problems;

import java.util.Scanner;

class TeamBmiCalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] heights = new double[5];
        double[] weights = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter height in meters for person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);
    }
}
