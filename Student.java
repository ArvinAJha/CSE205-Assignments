import java.text.NumberFormat;
import java.util.Locale;

public abstract class Student {

    //instance fields
    protected String firstName, lastName, studentID;
    protected int creditNum;
    protected double rate;
    protected double tuition;

    //constructor
    public Student(String firstName, String lastName, String studentID, int creditNum, double rate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.creditNum = creditNum;
        this.rate = rate;
        this.tuition = 0.0;
    }

    /**
     * 
     * @return number of credits
     */
    public int getCreditNum() {
        return creditNum;
    }

    /**
     * returns basic message stating a student's first name, last name, id, credits, rate, and tuition
     */
    public String toString() {

        //use US dollar message format for tuition and rate
        Locale usMoney = new Locale("en", "US");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(usMoney);

        return "\nFirst name:\t\t" + firstName + "\n" +
                "Last name:\t\t" + lastName + "\n" +
                "Student ID:\t\t" + studentID + "\n" +
                "Credits:\t\t" + creditNum + "\n" +
                "Rate:\t\t\t" + moneyFormat.format(rate) + "\n" + //if not work then try adding $ here
                "Tuition:\t\t" + moneyFormat.format(tuition) + "\n";
    }

    /**
     * method to be overrided by child classes that  compute tuition 
     */
    public abstract void computeTuition();

}
