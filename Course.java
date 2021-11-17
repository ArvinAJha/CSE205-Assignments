import java.io.Serializable;

import LinkedLists.AssignmentLinkedList;
import LinkedLists.QuizLinkedList;
import LinkedLists.TestLinkedList;

public class Course implements Serializable {

    private String name, code;
    private boolean lowestTestDropped;
    private AssignmentLinkedList assignments;
    private QuizLinkedList quizzes;
    private TestLinkedList tests;

    private double assignmentPercentWorth;
    private double quizWorth;
    private double testWorth;

    public Course (String name, String code, boolean lowestTestDropped, double assignmentWorth, double testWorth, double quizWorth) {
        this.name = name;
        this.code = code;
        assignments = new AssignmentLinkedList();
        quizzes = new QuizLinkedList();
        tests = new TestLinkedList();
    }

    public Course () {
        this.name = "name";
        this.code = "code";
        assignments = new AssignmentLinkedList();
        quizzes = new QuizLinkedList();
        tests = new TestLinkedList();
    }

    public void printAll() {
        assignments.printList();
        //tests and quizzes here too
    }

    //getters
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public double getAssignmentWorth() {
        return assignmentPercentWorth;
    }
    public double getQuizWorth() {
        return quizWorth;
    }
    public double getTestWorth() {
        return testWorth;
    }
    public AssignmentLinkedList getAssignmentLinkedList() {
        return assignments;
    }
    public QuizLinkedList getQuizLinkedList() {
        return quizzes;
    }
    public TestLinkedList getTestLinkedList() {
        return tests;
    }

    public boolean isLowestTestDropped() {
        return lowestTestDropped;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void sortByName() {
        assignments.sortByName();
        tests.sort();
        quizzes.sort();
    }

    public double calculate() { //  MAKE SURE TO HAVE THE TEST AND QUIZZES
        try {
            return assignments.getGradeSum()/assignments.getAvailablePointsSum() * assignmentPercentWorth;
        } catch (ArithmeticException e) {
            
        } 
        
        return 0;
    }

    @Override
    public String toString() {
        return code + ": " + name;
    }

}
