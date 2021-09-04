import java.text.NumberFormat;
import java.util.Locale;

public class OnlineStudent extends Student {

    //instance fields
    private double computingFee;

    //constructor
    public OnlineStudent(String firstName, String lastName, String studentID, int creditNum, double rate, double computingFee) {
        
        super(firstName, lastName, studentID, creditNum, rate);
        this.computingFee = computingFee;
    }

    @Override
    /**
     * compute tuiton unique to online students only
     */
    public void computeTuition() {
        tuition = (rate + computingFee) * creditNum;
    }

    /**
     * @returnformatted message based on generic student message + computing fee
     */
    public String toString() {
        
        //use US dollar message format for tuition and rate
        Locale usMoney = new Locale("en", "US");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(usMoney);

        return "\nOnline Student:" + 
                super.toString() + //call the parent method to input the basic info easily
                "Computing Fee:\t\t" + moneyFormat.format(computingFee) + "\n\n";
    }
    
}
