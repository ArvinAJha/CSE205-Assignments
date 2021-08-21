// Assignment #: 1
// Name: Arvin Jha
// StudentID: 1221497264
// Lecture: 10:10AM - 11:00AM
// Time took you to complete the assignment: 30 minutes
// Description: This class reads an integer from a keyboard and prints it out
//              along with other messages.

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment1
 {
  public static void main (String[] args) {
    int number;

    Scanner reader = new Scanner(System.in);

    number = reader.nextInt();     // read an integer entered by a user


     // display the number with other messages
	  System.out.print("This program reads an integer from a keyboard\n"
	                  + "and prints it out on the display screen.\n"
	                  + "Make sure that you get the exact same output as the expected one.\n"
                    + "The read number is: " + number + "\n");

    reader.close();
   }

 }


