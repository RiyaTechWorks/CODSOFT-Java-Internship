import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            StudentManagementSystem sms =
                    new StudentManagementSystem();

            sms.loadFromFile();

            int choice;

            do {

                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Edit Student");
                System.out.println("6. Save Data");
                System.out.println("7. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch(choice) {

                    case 1 -> {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        if(name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Grade: ");
                        String grade = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        if(!email.contains("@")) {
                            System.out.println("Invalid Email.");
                            break;
                        }

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        Student student =
                                new Student(name, roll,
                                        grade, email,
                                        department);

                        sms.addStudent(student);
                    }

                    case 2 -> {
                        System.out.print("Enter Roll Number: ");
                        int removeRoll = sc.nextInt();

                        sms.removeStudent(removeRoll);
                    }

                    case 3 -> {
                        System.out.print("Enter Roll Number: ");
                        int searchRoll = sc.nextInt();

                        Student found =
                                sms.searchStudent(searchRoll);

                        if(found != null) {
                            System.out.println(found);
                        }
                        else {
                            System.out.println("Student not found.");
                        }
                    }

                    case 4 -> sms.displayStudents();

                    case 5 -> {
                        System.out.print("Enter Roll Number: ");
                        int editRoll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Grade: ");
                        String newGrade = sc.nextLine();

                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDepartment = sc.nextLine();

                        sms.editStudent(
                                editRoll,
                                newName,
                                newGrade,
                                newEmail,
                                newDepartment
                        );
                    }

                    case 6 -> sms.saveToFile();

                    case 7 -> {
                        sms.saveToFile();

                        System.out.println("Exiting...");
                    }

                    default -> System.out.println("Invalid choice.");
                }

            } while(choice != 7);

            sc.close();
        }
    }
}