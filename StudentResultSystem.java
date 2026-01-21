import java.util.Scanner;

public class StudentResultSystem {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== Student Result Processing System =====\n");

        char choice;

        do {
            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();

            int subjectCount = getSubjectCount();

            String[] subjects = new String[subjectCount];
            int[] marks = new int[subjectCount];

            int totalMarks = 0;

            // ===== Taking Subject Names and Marks =====
            for (int i = 0; i < subjectCount; i++) {

                System.out.print("Enter Subject " + (i + 1) + " Name: ");
                subjects[i] = input.nextLine();

                marks[i] = getValidMarks(subjects[i]);
                totalMarks += marks[i];
            }

            // ===== Calculate Percentage =====
            double percentage = (double) totalMarks / subjectCount;

            // ===== Assign Grade =====
            String grade = assignGrade(percentage);

            // ===== Display Final Result =====
            displayResult(studentName, subjects, marks, totalMarks, percentage, grade);

            System.out.print("\nDo you want to enter another student? (y/n): ");
            choice = input.next().charAt(0);
            input.nextLine(); // clear buffer
            System.out.println();

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Program Ended. Thank You!");
        input.close();
    }

    // ===== Method to get number of subjects =====
    public static int getSubjectCount() {
        int count;
        while (true) {
            System.out.print("Enter Number of Subjects: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid Input! Enter numeric value.");
                input.next();
                continue;
            }

            count = input.nextInt();
            input.nextLine(); // clear buffer

            if (count <= 0) {
                System.out.println("Number of subjects must be greater than zero!");
                continue;
            }
            break;
        }
        return count;
    }

    // ===== Method for Marks Validation =====
    public static int getValidMarks(String subjectName) {
        int marks;
        while (true) {
            System.out.print("Enter Marks for " + subjectName + " (0-100): ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid Input! Enter numeric marks.");
                input.next();
                continue;
            }

            marks = input.nextInt();
            input.nextLine(); // clear buffer

            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100!");
                continue;
            }
            break;
        }
        return marks;
    }

    // ===== Method to Assign Grade =====
    public static String assignGrade(double percentage) {

        if (percentage >= 90) return "A (Excellent)";
        else if (percentage >= 80) return "B (Very Good)";
        else if (percentage >= 70) return "C (Good)";
        else if (percentage >= 60) return "D (Pass)";
        else return "F (Fail)";
    }

    // ===== Method to Display Result =====
    public static void displayResult(String name, String[] subjects, int[] marks,
                                     int total, double percentage, String grade) {

        System.out.println("\n========== RESULT ==========");
        System.out.println("Student Name : " + name);
        System.out.println("----------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + " : " + marks[i]);
        }

        System.out.println("----------------------------");
        System.out.println("Total Marks : " + total);
        System.out.printf("Percentage  : %.2f%%\n", percentage);
        System.out.println("Grade       : " + grade);
        System.out.println("============================");
    }
}
