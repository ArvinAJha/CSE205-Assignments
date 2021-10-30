/**
 * Assignment #7 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: This class represenst an object of type instructor. An instructor has a  first name, last name and office number
*/

import java.io.Serializable;

public class Instructor implements Serializable
{
   //instance variables
    private String firstName;
    private String lastName;
    private String officeNum;

    //constructor
    public Instructor(String firstName, String lastName, String officeNum)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNum = officeNum;
    }
    //accessor methods
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getOfficeNum()
    {
        return officeNum;
    }
    //mutator methods
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setOfficeNum(String level)
    {
        officeNum = level;
    }
    //returns a string that represenst an instructor
    public String toString()
    {
        return firstName + " " + lastName + ", " + officeNum;
    }
}
