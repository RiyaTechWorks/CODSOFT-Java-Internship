import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {

    private final ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {

        Student student = searchStudent(rollNumber);

        if(student != null) {
            students.remove(student);
            System.out.println("Student removed successfully.");
        }
        else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudent(int rollNumber) {

        for(Student student : students) {

            if(student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }

    public void displayStudents() {

        if(students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void editStudent(int rollNumber,
                            String name,
                            String grade,
                            String email,
                            String department) {

        Student student = searchStudent(rollNumber);

        if(student != null) {

            student.setName(name);
            student.setGrade(grade);
            student.setEmail(email);
            student.setDepartment(department);

            System.out.println("Student updated successfully.");
        }
        else {
            System.out.println("Student not found.");
        }
    }

    public void saveToFile() {

        try {

            try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
                for(Student student : students) {
                    
                    writer.println(
                            student.getName() + "," +
                                    student.getRollNumber() + "," +
                                    student.getGrade() + "," +
                                    student.getEmail() + "," +
                                    student.getDepartment()
                    );
                }
            }

            System.out.println("Data saved successfully.");

        } catch(IOException e) {

            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile() {

        try {

            File file = new File("students.txt");

            if(!file.exists()) {
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                
                while((line = reader.readLine()) != null) {
                    
                    String[] data = line.split(",");
                    
                    students.add(
                            new Student(
                                    data[0],
                                    Integer.parseInt(data[1]),
                                    data[2],
                                    data[3],
                                    data[4]
                            )
                    );
                }
            }

        } catch(IOException | NumberFormatException e) {

            System.out.println("Error loading file.");
        }
    }
}