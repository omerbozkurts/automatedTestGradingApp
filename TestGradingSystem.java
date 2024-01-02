//package edu.yalova;

import java.util.*;

    public class TestGradingSystem {
        private List<Student> studentList = new ArrayList<>();
        private Map<Integer, String> correctAnswers = new HashMap<>();
        private LinkedList<Student> gradingQueue = new LinkedList<>();
        private Queue<Student> overallGradingQueue = new LinkedList<>();
        private Map<Integer, Double> gradedResults = new HashMap<>();
        private List<Double> reportData = new ArrayList<>();
        private TreeMap<Integer, Double> gradeBook = new TreeMap<>();

        private Map<Integer, Student> studentMap = new HashMap<>();

        public TestGradingSystem() {
        }

        public List<Student> getStudentList() {
            return studentList;
        }

        public void setStudentList(List<Student> studentList) {
            this.studentList = studentList;
        }

        public Map<Integer, String> getCorrectAnswers() {
            return correctAnswers;
        }

        public void setCorrectAnswers(Map<Integer, String> correctAnswers) {
            this.correctAnswers = correctAnswers;
        }

        public LinkedList<Student> getGradingQueue() {
            return gradingQueue;
        }

        public void setGradingQueue(LinkedList<Student> gradingQueue) {
            this.gradingQueue = gradingQueue;
        }


        public Queue<Student> getOverallGradingQueue() {
            return overallGradingQueue;
        }

        public void setOverallGradingQueue(Queue<Student> overallGradingQueue) {
            this.overallGradingQueue = overallGradingQueue;
        }

        public Map<Integer, Double> getGradedResults() {
            return gradedResults;
        }

        public void setGradedResults(Map<Integer, Double> gradedResults) {
            this.gradedResults = gradedResults;
        }

        public List<Double> getReportData() {
            return reportData;
        }

        public void setReportData(List<Double> reportData) {
            this.reportData = reportData;
        }

        public TreeMap<Integer, Double> getGradeBook() {
            return gradeBook;
        }

        public void setGradeBook(TreeMap<Integer, Double> gradeBook) {
            this.gradeBook = gradeBook;
        }

        public Map<Integer, Student> getStudentMap() {
            return studentMap;
        }

        public void setStudentMap(Map<Integer, Student> studentMap) {
            this.studentMap = studentMap;
        }

        // Adding students to the student list
        // Adding students to the grading queue
        // Add student to studentIdNameMap
        public void addStudent(Student student) {
            this.studentList.add(student);
            this.gradingQueue.add(student);
            this.studentMap.putIfAbsent(student.getStudentID(), student);
        }

        public void removeStudent(Student student) {
            this.studentList.remove(student);
            this.gradingQueue.remove(student);
            this.studentMap.remove(student.getStudentID());
        }

        public Student findStudentById(int studentId) {
            return this.studentMap.get(studentId);
        }

        public double calculateAverage() {
            double totalScore = 0;
            for(double score : reportData) {
                totalScore+= score;
            }
            return totalScore / reportData.size();
        }

        //https://www.baeldung.com/java-stack
        public double calculateGrade(Student student) {
            List<String> answers = student.getAnswers();
            if(null != answers) {
                int totalQuestions = answers.size();
                Stack<Integer> currentScoreStack = new Stack<Integer>();
                currentScoreStack.push(0);

                for (int i = 0; i < totalQuestions; i++) {
                    if (answers.get(i).equals(correctAnswers.get(i))) {
                        Integer currentScore = currentScoreStack.pop();
                        currentScoreStack.push(currentScore+1);
                    }
                }

                // Calculate the grade as the ratio of correct answers to total questions
                return (double) currentScoreStack.pop() / totalQuestions * 100;
            }
            return 0.0;
        }
}
