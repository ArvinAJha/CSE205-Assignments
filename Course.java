import java.util.ArrayList;

public class Course {

    private String name, code;
    private int assignmentNum, quizNum, testNum;
    private double assignmentTotal, quizTotal, testTotal;
    private double assignmentWeight, testWeight, quizWeight;
    private boolean lowestTestDropped;
    private double ABounds, APlusBounds, AMinusBounds, BPlusBounds, BBounds, BMinusBounds, CPlusBounds, CBounds, CMinusBounds, DPlusBoubds, DBoubds, DMinusBoubds, EBounds;

    private double finalGrade;
    private String finalLetterGrade;
    
    private ArrayList<Double> tests;


    public Course (String name, String code, int assignmentNum, int quizNum, int testNum, double assignmentTotal, double quizTotal, double testTotal) {
        this.name = name;
        this.code = code;
        this.assignmentNum = assignmentNum;
        this.quizNum = quizNum;
        this.testNum = testNum;
        this.assignmentTotal = assignmentTotal;
        this.quizTotal = quizTotal;
        this.testTotal = testTotal;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public int getAssignmentNum() {
        return assignmentNum;
    }
    public int getQuizNum() {
        return quizNum;
    }
    public int getTestNum() {
        return testNum;
    }
    public double getAssignmentTotal() {
        return assignmentTotal;
    }
    public double getQuizTotal() {
        return quizTotal;
    }
    public double testTotal() {
        return testTotal;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setAssignmentNum(int assignmentNum) {
        this.assignmentNum = assignmentNum;
    }
    public void setQuizNum(int quizNum) {
        this.quizNum = quizNum;
    }
    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }

    private void calculateGrade() {
    }

}
