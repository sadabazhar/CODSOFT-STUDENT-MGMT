package main.view;

import main.controller.StudentController;
import main.model.Student;

import java.util.List;
import java.util.Scanner;

public class MainConsoleUI {
    static Scanner scanner = new Scanner(System.in);
    static StudentController controller = new StudentController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll No");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAll();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addStudent() {
        Student s = readStudentInput();
        boolean result = controller.addStudent(s);
        System.out.println(result ? "Student Added." : "Failed to Add.");
    }

    static void viewAll() {
        List<Student> list = controller.getAllStudents();
        list.forEach(System.out::println);
    }

    static void searchStudent() {
        System.out.print("Enter Roll No: ");
        String roll = scanner.nextLine();
        Student s = controller.getStudent(roll);
        System.out.println(s != null ? s : "Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        String roll = scanner.nextLine();
        Student s = controller.getStudent(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Leave field empty to keep previous value.");
        System.out.print("New Name (" + s.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isBlank()) s.setName(name);

        System.out.print("New Grade (" + s.getGrade() + "): ");
        String grade = scanner.nextLine();
        if (!grade.isBlank()) s.setGrade(grade);

        System.out.print("New Email (" + s.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isBlank()) s.setEmail(email);

        System.out.print("New Phone (" + s.getPhone() + "): ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) s.setPhone(phone);

        System.out.print("New Address (" + s.getAddress() + "): ");
        String address = scanner.nextLine();
        if (!address.isBlank()) s.setAddress(address);

        boolean result = controller.updateStudent(s);
        System.out.println(result ? "Student Updated." : "Update Failed.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        String roll = scanner.nextLine();
        boolean result = controller.deleteStudent(roll);
        System.out.println(result ? "Student Deleted." : "Delete Failed.");
    }

    static Student readStudentInput() {
        System.out.print("Roll No: ");
        String roll = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();

        return new Student(roll, name, grade, email, phone, address);
    }
}
