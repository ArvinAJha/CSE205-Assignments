// Assignment #: 9
//         Name: To be completed
//    StudentID: To be completed
//      Lecture: To be completed
//  Description: this program reads in a sequence of numbers from standard
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
            line = bufferedReader.readLine();
            i++;
            while(!line.equals("0")) {
                // read in the number as a string and parse to an integer and assign
                // it to array element

                numbers[i] = Double.parseDouble(line);
                line = bufferedReader.readLine();
                i++;
                
            } // Continue iterating until 0 is entered

        } // end of try block

        // Catch an IO Exception and print out that it occurs
        catch (IOException ex)
        {
            System.out.println("IO Exception");
        }

        // Call recursive functions findMin, findSumAtOdd, findPositiveSum, findNegative
        DecimalFormat minFormat = new DecimalFormat("#.00");

        DecimalFormat oddFormat = new DecimalFormat("###.0##");
        oddFormat.setRoundingMode(RoundingMode.HALF_UP);

        DecimalFormat posFormat = new DecimalFormat("###.#");
        posFormat.setRoundingMode(RoundingMode.HALF_DOWN);

        double min = findMin(numbers, 0, i, 0);
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
    public static double findMin(double[] numbers, int startIndex, int endIndex, double min)
    {
        if(startIndex == endIndex) {
            return min;
        } else if(numbers[startIndex] < min) {
            min = numbers[startIndex];
        }
        return findMin(numbers, startIndex+1, endIndex, min);

    }
    
    public static double findSumAtOdd(double[] numbers, int startIndex, int endIndex)
    {
        if(startIndex >= endIndex) {
            return 0;
        } else if(startIndex % 2 != 0) {
            return numbers[startIndex] + findSumAtOdd(numbers, startIndex+2, endIndex);
        } else {
            return findSumAtOdd(numbers, startIndex+1, endIndex);
        }
    }

    // Recursive static method to find the sum of positive numbers in the array
    // between the indexes startIndex and endIndex (parameter)
    public static double findPositiveSum(double[] numbers, int startIndex, int endIndex)
    {
        if(startIndex == endIndex) {
            return 0;
        } else if(numbers[startIndex] > 0) {
            return numbers[startIndex] + findPositiveSum(numbers, startIndex+1, endIndex);
        } else {
            return findPositiveSum(numbers, startIndex+1, endIndex);
        }
    }

    // Recursive static method to find how many negative numbers are between the
    // indexes startIndex and endIndex
    public static int findNegative(double[] numbers, int startIndex, int endIndex)
    {
        if(startIndex == endIndex) {
            return 0;
        } else if(numbers[startIndex] < 0) {
            return 1 + findNegative(numbers, startIndex+1, endIndex);
        } else {
            return findNegative(numbers, startIndex+1, endIndex);
        }
    }
}// End Assignment9 class