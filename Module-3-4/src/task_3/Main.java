package task_3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "enrollment.ser";

        Student student = new Student(1, "Ram", 25);
        Course course = new Course("CS101", "Introduction to Python Programming", "Laxman Hari Sharma");
        Enrollment enrollment = new Enrollment(student, course, "15.08.2025");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(enrollment);
            System.out.println("Enrollment serialized to " + fileName);
        } catch (IOException e) {
            System.err.println(e);
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Enrollment deserialized = (Enrollment) ois.readObject();
            System.out.println("Deserialized enrollment: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
