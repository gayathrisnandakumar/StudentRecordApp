public class Student {
    private int id;
    private String name;
    private String rollNumber;
    private String department;
    private int semester;
    private double marks;

    // Constructor - runs when you create a new Student object
    public Student(int id, String name, String rollNumber, String department, int semester, double marks) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.semester = semester;
        this.marks = marks;
    }

    // Getters - let other files read these private values
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public String getDepartment() { return department; }
    public int getSemester() { return semester; }
    public double getMarks() { return marks; }
}