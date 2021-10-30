import java.io.Serializable;

/**
 * Assignment #7 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: The Course class creates a singular Course with a name, instructor, and university of the course 
 *              used to store the details of the course a user enrolls in
*/



public class Course implements Serializable
{
    //instance varaibles
    private String courseName;
    private String university;
    private Instructor instructor;

    //constructor
    public Course(String courseName, String university, Instructor instructor)
    {
        super();
        this.courseName = courseName;
        this.university = university;
        this.instructor = instructor;
    }
    //accessor method
    public String getCourseName()
    {
        return courseName;
    }
    //mutator method
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    //accessor method
    public String getUniversity()
    {
        return university;
    }

    //accessor method
    public void setUniversity(String university)
    {
        this.university = university;
    }
    //accessor method
    public Instructor getInstructor()
    {
        return instructor;
    }
    //mutator method
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }
    //returns a string that represnets a Course object
    public String toString()
    {
        return "\nCourseName:\t\t" + courseName + "\n" + "University:\t\t" + university + "\n" + "Instructor:\t\t"
                + instructor.toString() + "\n";
    }

}
