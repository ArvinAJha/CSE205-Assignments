import java.util.Scanner;

public class Assignment2 {

    // variables for all number values required
    private static int minNum; 
    private static int largeOdd; 
    private static int negativeNumCount;
    private static int sumOfEvenInt;

    // constants for all messages to print out
    private static final String MIN_NUM_STRING = "The minimum integer is ";
    private static final String LARGE_ODD_STRING = "The largest odd integer in the sequence is ";
    private static final String NEG_NUM_COUNT_STRING = "The count of negative integers in the sequence is ";
    private static final String SUM_OF_EVEN_INTS_STRING = "The sum of even integers is ";


    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        int nextNumber = reader.nextInt();

        while(nextNumber != 0) {

            if(nextNumber < minNum) { //see if new number is smaller than the already minimum number
                minNum = nextNumber;
            }

            if(nextNumber % 2 == 0) {               //if number is event
                sumOfEvenInt += nextNumber;         //add new number to other even numbers
            } else if(nextNumber % 2 != 0) {                                //otherwise nunmber is odd
                
                if( nextNumber > largeOdd) {        //see if new odd number can be the largest odd number
                    largeOdd = nextNumber;
                }
            }

            if(nextNumber < 0) { //if number is negative
                negativeNumCount++;
            }
            nextNumber = reader.nextInt(); //read next number in file and repeat process
        }

        System.out.print(MIN_NUM_STRING + minNum + "\n" +
                         LARGE_ODD_STRING + largeOdd + "\n" +
                         NEG_NUM_COUNT_STRING + negativeNumCount + "\n" +
                         SUM_OF_EVEN_INTS_STRING + sumOfEvenInt);

        reader.close();
    }

}