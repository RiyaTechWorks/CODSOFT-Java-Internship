public class Student {

    private String name;
    private final int rollNumber;
    private String grade;
    private String email;
    private String department;

    public Student(String name, int rollNumber, String grade,
                   String email, String department) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber +
                ", Name: " + name +
                ", Grade: " + grade +
                ", Email: " + email +
                ", Department: " + department;
    }
}