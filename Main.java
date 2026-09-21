import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clears the leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Roll Number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Semester: ");
                    int semester = scanner.nextInt();
                    System.out.print("Marks: ");
                    double marks = scanner.nextDouble();
                    dao.addStudent(name, rollNumber, department, semester, marks);
                    break;

                case 2:
                    dao.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String uName = scanner.nextLine();
                    System.out.print("New Roll Number: ");
                    String uRoll = scanner.nextLine();
                    System.out.print("New Department: ");
                    String uDept = scanner.nextLine();
                    System.out.print("New Semester: ");
                    int uSem = scanner.nextInt();
                    System.out.print("New Marks: ");
                    double uMarks = scanner.nextDouble();
                    dao.updateStudent(updateId, uName, uRoll, uDept, uSem, uMarks);
                    break;

                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
