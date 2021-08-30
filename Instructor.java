/*
Assignment #: 4
Name: Arvin Jha
StudentID: 1221497264
Lecture: 10AM CSE205 M W F
Description: Instructor describes the information of the university instructor for a particular course. Its attributes hold
    the first and last name and its office number.
*/


public class Instructor {

    //instance fields
    private String firstName;
    private String lastName;
    private String officeNum;

    /**
     * constructs a new instructor with specified input
     * @param firstName
     * @param lastName
     * @param office
     */
    public Instructor(String firstName, String lastName, String office) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNum = office;
    }

    //constructs default instructor
    public Instructor() {
        this.firstName = "?";
        this.lastName = "?";
        this.officeNum = "?";
    }

    /**
     * 
     * @return first name of instructor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return last name of instructor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @return instructor's office number
     */
    public String getOfficeNum() {
        return officeNum;
    }

    /**
     * changes instructor's first name with new name based on parameter
     * @param newName
     */
    public void setFirstName(String newName) {
        firstName = newName;
    }

    /**
     * changes instructor's last name with new name based on parameter
     * @param newName
     */
    public void setLastName(String newName) {
        lastName = newName;
    }

    /**
     * changes instructor's office number with new office number based on provided input
     * @param newOfficeNumber
     */
    public void setOfficeNumber(String newOfficeNumber) {
        officeNum = newOfficeNumber;
    }

    /**
     * @return returns string message in a specified format 
     */
    public String toString() {
        return "\nLast Name:\t" + lastName + "\nFirst Name:\t" + firstName + "\nOffice Number:\t" + officeNum + "\n";
    }

}
