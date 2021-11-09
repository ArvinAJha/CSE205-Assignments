public class Course {

    private String name, code;
    private boolean lowestTestDropped;
    private double ABounds, APlusBounds, AMinusBounds, BPlusBounds, BBounds, BMinusBounds, CPlusBounds, CBounds, CMinusBounds, DPlusBounds, DBounds, DMinusBounds, EBounds;
    private AssignmentLinkedList assignments;
    private double assignmentPercentWorth;
    private QuizLinkedList quizzes;
    private double quizWorth;
    private TestLinkedList tests;
    private double testWorth;


    public Course (String name, String code, double assignmentWorth, double quizWorth, double testWorth, double ABounds, double APlusBounds, double AMinusBounds, double BPlusBounds, double BBounds, double BMinusBounds, double CPlusBounds, double CBounds, double CMinusBounds, double DPlusBoubds, double DBoubds, double DMinusBoubds, double EBounds) {
        this.name = name;
        this.code = code;
        assignments = new AssignmentLinkedList();
        quizzes = new QuizLinkedList();
        tests = new TestLinkedList();
        this.ABounds = ABounds;
        this.APlusBounds = APlusBounds;
        this.AMinusBounds = AMinusBounds;
        this.BPlusBounds = BPlusBounds;
        this.BBounds = BBounds;
        this.BMinusBounds = BMinusBounds;
        this.CPlusBounds = CPlusBounds;
        this.CBounds = CBounds;
        this.CMinusBounds = CMinusBounds;
        this.DPlusBounds = DPlusBoubds;
        this.DBounds = DBoubds;
        this.DMinusBounds = DMinusBoubds;
        this.EBounds = EBounds;
    }

    public Course () {
        this.name = "name";
        this.code = "code";
        assignments = new AssignmentLinkedList();
        quizzes = new QuizLinkedList();
        tests = new TestLinkedList();
        this.ABounds = 0;
        this.APlusBounds = 0;
        this.AMinusBounds = 0;
        this.BPlusBounds = 0;
        this.BBounds = 0;
        this.BMinusBounds = 0;
        this.CPlusBounds = 0;
        this.CBounds = 0;
        this.CMinusBounds = 0;
        this.DPlusBounds = 0;
        this.DBounds = 0;
        this.DMinusBounds = 0;
        this.EBounds = 0;
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
    public AssignmentLinkedList getAssignmentList() {
        return assignments;
    }
    public QuizLinkedList getQuizList() {
        return quizzes;
    }
    public TestLinkedList getTestList() {
        return tests;
    }

    public String getBounds(String bounds) {
        String switchString = bounds.toUpperCase();
        String resultString  = "";

        switch (switchString) {

            case "A": resultString = APlusBounds + "/" + ABounds + "/" + AMinusBounds;
            case "B": resultString = BPlusBounds + "/" + BBounds + "/" + BMinusBounds;
            case "C": resultString = CPlusBounds + "/" + CBounds + "/" + CMinusBounds;
            case "D": resultString = DPlusBounds + "/" + DBounds + "/" + DMinusBounds;
            case "E": resultString = EBounds + "/";
            default: resultString = "NONE/";
        }

        return resultString;
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
        //tests.sort();
        //quizzes.sort();
    }

    public double calculate() { //  MAKE SURE TO HAVE THE TEST AND QUIZZES
        return assignments.getAssignmentSum()/assignments.getAvailablePointsSum() * assignmentPercentWorth;
    }

}
