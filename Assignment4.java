/*
Assignment #: 4
Name: Arvin Jha
StudentID: 1221497264
Lecture: 10AM CSE205 M W F
Description: Assignment 4 class displays a menu of choices to a user
  and performs the chosen task. It will keep asking a user to
 enter the next choice until the choice of 'Q' (Quit) is entered.
*/

import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        
        // local variables, can be accessed anywhere from the main method
        char input1 = 'Z';
        // String inputInfo= "";
        String courseName, firstName, lastName, office, university;
        String line = new String();

        // instantiate a Course object
        Course cse110 = null;

        printMenu();

        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        do // will ask for user input
        {
            System.out.println("What action would you like to perform?");
            line = scan.nextLine();

            if (line.length() == 1) {
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                // matches one of the case statement
                switch (input1) {
                    case 'A': // Add a course

                        System.out.print("Please enter the Instructor information:\n");
                        System.out.print("Enter instructor's first name:\t");
                        firstName = scan.nextLine();
                        System.out.print("Enter instructor's last name:\t");
                        lastName = scan.nextLine();
                        System.out.print("Enter instructor's office number:\t");
                        office = scan.nextLine();
                        Instructor myInstructor = new Instructor(firstName, lastName, office);

                        System.out.print("\nPlease enter the Course information:");
                        System.out.print("\nEnter course name:\t");
                        courseName = scan.nextLine();

                        System.out.print("Enter university name:\t");
                        university = scan.nextLine();
                        cse110 = new Course(courseName, myInstructor, university);
                        break;
                    case 'D': // Display course
                        System.out.print(cse110.toString());
                        break;
                    case 'Q': // Quit
                        break;
                    case '?': // Display Menu
                        printMenu();
                        break;
                    default:
                        System.out.print("Unknown action\n");
                        break;
                }
            } else {
                System.out.print("Unknown action\n");
            }
        } while (input1 != 'Q' || line.length() != 1);
        scan.close();
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd Course\n" + "D\t\tDisplay Course\n"
                + "Q\t\tQuit\n" + "?\t\tDisplay Help\n\n");
    }

}
