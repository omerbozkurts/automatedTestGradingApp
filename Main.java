//package edu.yalova;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TestGradingSystem gradingSystem = new TestGradingSystem();

        // Adding students and their answers
        Student student1 = new Student();
        student1.setName("Selma Strbo");
        student1.setStudentID(210101091);
        student1.answers = Arrays.asList("A", "B", "C", "D");
        gradingSystem.getStudentList().add(student1);
        
        Student student2 = new Student();
        student2.setName("İlhan Mohamed Ibrahim");
        student2.setStudentID(200101132);
        student2.answers = Arrays.asList("A", "B", "C", "D");
        gradingSystem.getStudentList().add(student2);

        Student student3 = new Student();
        student3.setName("Onur Ünlü");
        student3.setStudentID(200101040);
        student3.answers = Arrays.asList("A", "B", "C", "D");
        gradingSystem.getStudentList().add(student3);

        Student student4 = new Student();
        student4.setName("Ahmet Can");
        student4.setStudentID(1);
        student4.answers = Arrays.asList("A", "B", "C", "A");
        gradingSystem.getStudentList().add(student4);

        Student student5 = new Student();
        student5.setName("Lale Can");
        student5.setStudentID(2);
        student5.answers = Arrays.asList("B", "B", "C", "A");
        gradingSystem.getStudentList().add(student5);

        Student student6 = new Student();
        student6.setName("Zeki Can");
        student6.setStudentID(3);
        student6.answers = Arrays.asList("C", "C", "C", "C");
        gradingSystem.getStudentList().add(student6);

        Student student7 = new Student();
        student7.setName("Random Can");
        student7.setStudentID(4);
        student7.answers = Arrays.asList("C", "C", "D", "A");
        gradingSystem.getStudentList().add(student6);

        // Adding correct answers to the hash map
        gradingSystem.getCorrectAnswers().put(0, "A");
        gradingSystem.getCorrectAnswers().put(1, "B");
        gradingSystem.getCorrectAnswers().put(2, "C");
        gradingSystem.getCorrectAnswers().put(3, "D");

        // Adding students to the grading queue
        gradingSystem.getGradingQueue().add(student1);
        gradingSystem.getGradingQueue().add(student2);
        gradingSystem.getGradingQueue().add(student3);
        gradingSystem.getGradingQueue().add(student4);
        gradingSystem.getGradingQueue().add(student5);
        gradingSystem.getGradingQueue().add(student6);
        gradingSystem.getGradingQueue().add(student7);

        // Grading process using stacks and queues
        //https://www.w3schools.com/java/java_linkedlist.asp
        while (!gradingSystem.getGradingQueue().isEmpty()) {
            // poll -> Retrieves and removes the head (first element) of this list.
            Student currentStudent = gradingSystem.getGradingQueue().poll();
            // Perform grading logic, update intermediate results using stacks, etc.
            gradingSystem.getOverallGradingQueue().add(currentStudent);
        }

        // Storing graded results in hash table
        for (Student student : gradingSystem.getOverallGradingQueue()) {
            double grade = gradingSystem.calculateGrade(student);
            //https://www.w3schools.com/java/java_hashmap.asp
            gradingSystem.getGradedResults().put(student.getStudentID(), grade);
        }

        // Generating summary reports and statistics using arrays
        for (double grade : gradingSystem.getGradedResults().values()) {
            gradingSystem.getReportData().add(grade);
        }

        //print average score
        System.out.println("Average score is " + gradingSystem.calculateAverage());

        // Organizing and displaying graded results hierarchically using binary trees
        for (Map.Entry<Integer, Double> entry : gradingSystem.getGradedResults().entrySet()) {
            gradingSystem.getGradeBook().put(entry.getKey(), entry.getValue());
        }

        // now we are printing results hierarchically
        // https://www.baeldung.com/java-treemap
        for (Map.Entry<Integer, Double> entry : gradingSystem.getGradeBook().entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Name: " + gradingSystem.getStudenIdNameMap().get(entry.getKey()) + ", Grade: " + entry.getValue());
        }
    }
}