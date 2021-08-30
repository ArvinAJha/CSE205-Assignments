/*
Assignment #: 4
Name: Arvin Jha
StudentID: 1221497264
Lecture: 10AM CSE205 M W F
Description: Assignment 4 class displays a menu of choices to a user
  and performs the chosen task. It will keep asking a user to
 enter the next choice until the choice of 'Q' (Quit) is entered.
*/


public class Instructor {

    private String firstName;
    private String lastName;
    private String officeNum;

    public Instructor(String firstName, String lastName, String office) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNum = office;
    }

    public Instructor() {
        this.firstName = "?";
        this.lastName = "?";
        this.officeNum = "?";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOfficeNum() {
        return officeNum;
    }

    public void setFirstName(String newName) {
        firstName = newName;
    }

    public void setLastName(String newName) {
        lastName = newName;
    }

    public void setOfficeNumber(String newOfficeNumber) {
        officeNum = newOfficeNumber;
    }

    public String toString() {
        return "\nLast Name:\t" + lastName + "\nFirst Name:\t" + firstName + "\nOffice Number:\t" + officeNum + "\n";
    }

}
