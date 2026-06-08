import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    String department;
    String subject;
    int marks;
    String grade;

    Student(int id, String name, String department, String subject, int marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.subject = subject;
        this.marks = marks;
        this.grade = grade();
    }

    private String grade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 80)
            return "B";
        else if (marks >= 70)
            return "C";
        else if (marks >= 60)
            return "D";
        else
            return "F";
    }
}

public class StudentCSV {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Abc", "CSE", "Java", 95));
        students.add(new Student(2, "Bcd", "ECE", "Python", 82));
        students.add(new Student(3, "Cde", "IT", "DBMS", 76));
        students.add(new Student(4, "Def", "CSE", "OS", 68));
        students.add(new Student(5, "Efg", "ECE", "CN", 58));
        students.add(new Student(6, "Fgk", "IT", "Java", 91));
        students.add(new Student(7, "Ghi", "CSE", "Python", 85));
        students.add(new Student(8, "Hij", "ECE", "DBMS", 73));
        students.add(new Student(9, "Ijk", "IT", "OS", 64));
        students.add(new Student(10, "Jkl", "CSE", "CN", 47));
        File folder = new File("output");
        folder.mkdirs();
        try {
            FileWriter writer = new FileWriter("output/students.csv");
            writer.write("Student ID,Name,Department,Subject,Marks,Grade\n");
            for (Student student : students) {
                writer.write(student.id + "," + student.name + "," + student.department + "," + student.subject + "," + student.marks + "," +  student.grade + "\n");
            }
            writer.close();
            System.out.println("students.csv created successfully in output folder");
        } catch (IOException e) {
            System.out.println("Error creating CSV file");
            e.printStackTrace();
        }
    }
}
