//package edu.yalova;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TestGradingSystem firstExam = new TestGradingSystem();

        // Adding students and their answers
        Student student1 = new Student();
        student1.setName("Selma Strbo");
        student1.setStudentID(210101091);
        student1.answers = Arrays.asList("A", "B", "C", "D");
        firstExam.addStudent(student1);

        Student student2 = new Student();
        student2.setName("İlhan Mohamed Ibrahim");
        student2.setStudentID(200101132);
        student2.answers = Arrays.asList("A", "B", "C", "D");
        firstExam.addStudent(student2);

        Student student3 = new Student();
        student3.setName("Onur Ünlü");
        student3.setStudentID(200101040);
        student3.answers = Arrays.asList("A", "B", "C", "D");
        firstExam.addStudent(student3);

        Student student4 = new Student();
        student4.setName("Ahmet Can");
        student4.setStudentID(1);
        student4.answers = Arrays.asList("A", "B", "C", "A");
        firstExam.addStudent(student4);

        Student student5 = new Student();
        student5.setName("Lale Can");
        student5.setStudentID(2);
        student5.answers = Arrays.asList("B", "B", "C", "A");
        firstExam.addStudent(student5);

        Student student6 = new Student();
        student6.setName("Zeki Can");
        student6.setStudentID(3);
        student6.answers = Arrays.asList("C", "C", "C", "C");
        firstExam.addStudent(student6);

        Student student7 = new Student();
        student7.setName("Random Can");
        student7.setStudentID(4);
        student7.answers = Arrays.asList("C", "C", "D", "A");
        firstExam.addStudent(student7);

        Student student8 = new Student();
        student8.setName("Sil Can");
        student8.setStudentID(777);
        student8.answers = Arrays.asList("B", "A", "D", "C");
        firstExam.addStudent(student8);

        // Adding correct answers to the hash map
        firstExam.getCorrectAnswers().put(0, "A");
        firstExam.getCorrectAnswers().put(1, "B");
        firstExam.getCorrectAnswers().put(2, "C");
        firstExam.getCorrectAnswers().put(3, "D");

        // remove student
        firstExam.removeStudent(student8);

        // Grading process using stacks and queues
        //https://www.w3schools.com/java/java_linkedlist.asp
        while (!firstExam.getGradingQueue().isEmpty()) {
            // poll -> Retrieves and removes the head (first element) of this list.
            Student currentStudent = firstExam.getGradingQueue().poll();
            // Perform grading logic, update intermediate results using stacks, etc.
            firstExam.getOverallGradingQueue().add(currentStudent);
        }

        // Storing graded results in hash table
        for (Student student : firstExam.getOverallGradingQueue()) {
            double grade = firstExam.calculateGrade(student);
            //https://www.w3schools.com/java/java_hashmap.asp
            firstExam.getGradedResults().put(student.getStudentID(), grade);
        }

        // Generating summary reports and statistics using arrays
        for (double grade : firstExam.getGradedResults().values()) {
            firstExam.getReportData().add(grade);
        }

        //print average score
        System.out.println("Average score is " + firstExam.calculateAverage());

        // Organizing and displaying graded results hierarchically using binary trees
        for (Map.Entry<Integer, Double> entry : firstExam.getGradedResults().entrySet()) {
            firstExam.getGradeBook().put(entry.getKey(), entry.getValue());
        }

        // now we are printing results hierarchically
        // https://www.baeldung.com/java-treemap
        for (Map.Entry<Integer, Double> entry : firstExam.getGradeBook().entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Name: " + firstExam.findStudentById(entry.getKey()).getName() + ", Grade: " + entry.getValue());
        }

        // second exam grading
        TestGradingSystem secondExam = new TestGradingSystem();

        // Adding correct answers to the hash map
        secondExam.getCorrectAnswers().put(0, "C");
        secondExam.getCorrectAnswers().put(1, "B");
        secondExam.getCorrectAnswers().put(2, "A");
        secondExam.getCorrectAnswers().put(3, "C");

        student1.answers = Arrays.asList("C", "B", "A", "C");
        student2.answers = Arrays.asList("C", "B", "A", "C");
        student3.answers = Arrays.asList("C", "B", "A", "C");

        secondExam.addStudent(student1);
        secondExam.addStudent(student2);
        secondExam.addStudent(student3);

        // Grading process using stacks and queues
        //https://www.w3schools.com/java/java_linkedlist.asp
        while (!secondExam.getGradingQueue().isEmpty()) {
            // poll -> Retrieves and removes the head (first element) of this list.
            Student currentStudent = secondExam.getGradingQueue().poll();
            // Perform grading logic, update intermediate results using stacks, etc.
            secondExam.getOverallGradingQueue().add(currentStudent);
        }

        // Storing graded results in hash table
        for (Student student : secondExam.getOverallGradingQueue()) {
            double grade = secondExam.calculateGrade(student);
            //https://www.w3schools.com/java/java_hashmap.asp
            secondExam.getGradedResults().put(student.getStudentID(), grade);
        }

        // Generating summary reports and statistics using arrays
        for (double grade : secondExam.getGradedResults().values()) {
            secondExam.getReportData().add(grade);
        }

        //print average score
        System.out.println("Average score is " + secondExam.calculateAverage());

        // Organizing and displaying graded results hierarchically using binary trees
        for (Map.Entry<Integer, Double> entry : secondExam.getGradedResults().entrySet()) {
            secondExam.getGradeBook().put(entry.getKey(), entry.getValue());
        }

        // now we are printing results hierarchically
        // https://www.baeldung.com/java-treemap
        for (Map.Entry<Integer, Double> entry : secondExam.getGradeBook().entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Name: " + secondExam.findStudentById(entry.getKey()).getName() + ", Grade: " + entry.getValue());
        }
    }
}