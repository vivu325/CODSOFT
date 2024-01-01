import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the marks obtained in each subject (out of 100):");

        int totalMarks = 0;
        int numberOfSubjects = 0;

        while (true) {
            System.out.print("Subject " + (numberOfSubjects + 1) + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                continue;
            }

            totalMarks += marks;
            numberOfSubjects++;

            System.out.print("Do you want to enter marks for another subject? (yes/no): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
