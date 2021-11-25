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

    /* constructors */

    /**
     * paramaterized constructor
     * @param name
     * @param code
     * @param lowestTestDropped
     * @param assignmentWorth
     * @param testWorth
     * @param quizWorth
     */
    public Course (String name, String code, boolean lowestTestDropped, double assignmentWorth, double testWorth, double quizWorth) {
        this.name = name;
        this.code = code;
        assignments = new AssignmentLinkedList();
        quizzes = new QuizLinkedList();
        tests = new TestLinkedList();
        this.assignmentPercentWorth = assignmentWorth;
        this.quizWorth = quizWorth;
        this.testWorth = testWorth;
    }

    /**
     * default constructor
     */
    public Course () {
        this.name = "name";
        this.code = "code";
        assignments = new AssignmentLinkedList();
        quizzes = new QuizLinkedList();
        tests = new TestLinkedList();
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
    public void setAssignmentWorth(double data) {
        assignmentPercentWorth = data;
    }
    public void setQuizWorth(double data) {
        quizWorth = data;
    }
    public void setTestWorth(double data) {
        testWorth = data;
    }
    public void setTestDropped(boolean dropped) {
        lowestTestDropped = dropped;
    }

    /**
     * add up all the calculates for each grade type and times by that grade's worth 
     * @return final grade
     */
    public double calculateFinal() {
        try {
            //return value of a grade type times grade worth
            return assignments.calculateGrade() * assignmentPercentWorth
                    + quizzes.calculateGrade() * quizWorth
                    + tests.calculateGrade(lowestTestDropped) * testWorth;
        } catch (ArithmeticException e) {
            System.out.println("error");
        } 
        
        return 0; // if there are errors then return 0 as default
    }

    @Override
    /**
     * course toString
     */
    public String toString() {
        return code + ": " + name;
    }

}
