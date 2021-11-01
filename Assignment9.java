// Assignment #: 9
//         Name: Arvin Jha
//    StudentID: 1221497264
//      Lecture: 10:10AM - 11:00AM M W F
//  Description: This program reads in a sequence of numbers from standard
//               input until 0 is read, stores the numbers in an array,
//               then finds the minimum number,
//               the sum of numbers at odd indexes,
//               the sum of positive numbers, and
//               the total count of negative numbers using recursion.

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Assignment9
{
    //the main method listens for input using a Buffered reader and calls methods to compute required values
    public static void main(String[] args)
    {

        // instantiate the array
        double[] numbers = new double[100];
        // index used for the array of numbers to be read
        int i = -1;
        // where to save one line of input
        String line;

        // Try-Catch block for input stream and buffered reader io exceptions
        try
        {
            // Create an input stream reader and buffered reader object
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            // while or do-While loop to store all integers in the array until 0
            line = bufferedReader.readLine();               //get initial line
            i++;                                            //running index
            while(!line.equals("0")) {

                numbers[i] = Double.parseDouble(line);      //add new line from previous loop iteration
                line = bufferedReader.readLine();           //read line
                i++;                                        //increase index
                
            } // Continue iterating until 0 is entered

        } // end of try block

        // Catch an IO Exception and print out that it occurs
        catch (IOException ex)
        {
            System.out.println("IO Exception");
        }

        //declare formatting for each unique value
        DecimalFormat minFormat = new DecimalFormat("#.00");                //format: must have two decimals after point

        DecimalFormat oddFormat = new DecimalFormat("0.0##");             //format: must have at least 1 deicmal after the point
        oddFormat.setRoundingMode(RoundingMode.HALF_UP);                    //        up to 3 decimals. Round up from .5 and higher

        DecimalFormat posFormat = new DecimalFormat("0.#");               //format: can have up to 1 decimal after the point but 
        posFormat.setRoundingMode(RoundingMode.HALF_DOWN);                  //        but not required. Round down decimal less than 0.5

        // Call recursive functions findMin, findSumAtOdd, findPositiveSum, findNegative
        double min = findMin(numbers, 0, i);
        double oddSum = findSumAtOdd(numbers, 0, i);
        double posSum = findPositiveSum(numbers, 0, i); //possum
        int neg = findNegative(numbers, 0, i);

        // Print out results in the required format
        System.out.println("The minimum number is " + minFormat.format(min) +
        "\nThe sum of numbers at odd indexes is " + oddFormat.format(oddSum) +
        "\nThe sum of positive numbers is " + posFormat.format(posSum) +
        "\nThe total count of negative numbers is " + neg);

    } // End main method

    // Recursive static method to find the smallest number in the array
    public static double findMin(double[] numbers, int startIndex, int endIndex)
    {
        double min;
        if(startIndex == endIndex) {
            return numbers[startIndex];
        } else {
            min = findMin(numbers, startIndex+1, endIndex);
            if(numbers[startIndex] <= min) {
                return numbers[startIndex];
            } else {
                return min;
            }
        }

    }
    
    //recursively find the sum of every odd number in the array
    public static double findSumAtOdd(double[] numbers, int startIndex, int endIndex)
    {
        if(startIndex >= endIndex) {    //if whole array is traversed, call base case and return 0
            return 0;
        } else if(startIndex % 2 != 0) {    //if position is odd
            return numbers[startIndex] + findSumAtOdd(numbers, startIndex+2, endIndex); //add value then call recursive to traverse rest of the array
        } else {                                                                        //move array size by 2 to move onto next odd position
            return findSumAtOdd(numbers, startIndex+1, endIndex); //if position is even then add nothing and move array forward by 1 to get to odd position
        }
    }

    // Recursive static method to find the sum of positive numbers in the array
    // between the indexes startIndex and endIndex (parameter)
    public static double findPositiveSum(double[] numbers, int startIndex, int endIndex)
    {
        if(startIndex == endIndex) { //base case, array traversered
            return 0;
        } else if(numbers[startIndex] > 0) {    //when positive
            return numbers[startIndex] + findPositiveSum(numbers, startIndex+1, endIndex);  //add current value then recursively call method, moving start index by 1
        } else {
            return findPositiveSum(numbers, startIndex+1, endIndex);    //when not positive, move recursion by 1 
        }
        //value of 0 not tested because addition of 0 is unnecessary
    }

    // Recursive static method to find how many negative numbers are between the
    // indexes startIndex and endIndex
    public static int findNegative(double[] numbers, int startIndex, int endIndex)
    {
        if(startIndex == endIndex) {    //base case
            return 0;
        } else if(numbers[startIndex] < 0) {    //when negative
            return 1 + findNegative(numbers, startIndex+1, endIndex);   //add 1 then call recursion moving start by 1
        } else {
            return findNegative(numbers, startIndex+1, endIndex);       //move recursion by 1 without adding when not negative
        }
        //value of 0 not tested because addition of 0 is unnecessary
    }
}// End Assignment9 class