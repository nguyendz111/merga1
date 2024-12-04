import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Display student list");
            System.out.println("4. Find student");
            System.out.println("5. Edit student information");
            System.out.println("6. Sort students by score (Merge Sort)");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    String id = getValidId(scanner);
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student score: ");
                    double score = scanner.nextDouble();
                    studentManager.addStudent(new Student(id, name, score));
                    break;
                case 2:
                    String removeId = getValidId(scanner);
                    studentManager.removeStudent(removeId);
                    break;
                case 3:
                    studentManager.displayStudents();
                    break;
                case 4:
                    String findId = getValidId(scanner);
                    Student foundStudent = studentManager.findStudent(findId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found with ID: " + findId);
                    }
                    break;
                case 5:
                    String editId = getValidId(scanner);
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    double newScore = scanner.nextDouble();
                    studentManager.editStudent(editId, newName, newScore);
                    break;
                case 6:
                    studentManager.sortByScoreMergeSort();  // Chọn thuật toán sắp xếp Merge Sort
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to get a valid student ID (non-empty and non-null)
    private static String getValidId(Scanner scanner) {
        String id;
        while (true) {
            System.out.print("Enter student ID: ");
            id = scanner.nextLine();
            if (id == null || id.trim().isEmpty()) {
                System.out.println("Invalid ID! ID cannot be empty or null. Please enter a valid ID.");
            } else {
                break; // Exit loop once a valid ID is entered
            }
        }
        return id;
    }
}
