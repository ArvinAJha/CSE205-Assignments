import java.text.NumberFormat;
import java.util.Locale;

public class OnCampusStudent extends Student {

    //instance fields
    private boolean resident; 
    private int creditUpperbound;
    private double studentProgramFee;

    //constructor
    public OnCampusStudent(String firstName, String lastName, String studentID, int creditNum, double rate, boolean resident, double studentProgramFee) {

        super(firstName, lastName, studentID, creditNum, rate);
        this.resident = resident;
        this.studentProgramFee = studentProgramFee;

        creditUpperbound = resident ? 7 : 12; //set the upper bound to 7 if the student is a resident or to 12 if they are not

    }

    @Override
    /**
     * compute tuition using formulas based on if the student has more or less than their credit threshold
     */
    public void computeTuition() {

        if(creditNum >= creditUpperbound) { 
            tuition = rate * creditUpperbound + studentProgramFee;
        } else {
            tuition = rate * creditNum + studentProgramFee;
        }
    }
    
    /**
     * @return formatted message based on generic student message + residency status and program fee
     */
    public String toString() {
        
        //use US dollar message format for tuition and rate
        Locale usMoney = new Locale("en", "US");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(usMoney);

        //set a temporary message to Resident if student is a resident and Nonresident if they are not
        String residentStatusString = resident ? "\nResident Status": "\nNonResident Status"; 

        return "\nOnCampus Student:" + 
                residentStatusString + 
                super.toString() + //call the parent method to input the basic info easily
                "Student Program Fee:\t" + moneyFormat.format(studentProgramFee) + "\n\n";
    }
}
