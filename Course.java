/*
Assignment #: 4
Name: Arvin Jha
StudentID: 1221497264
Lecture: 10AM CSE205 M W F
Description: Course is a class that describes a single particular course that the user has. Its attributes include the name of 
    the course, the associated university, and the instructor assignment to the course. 
 */

public class Course {

    //instance fields
    private String courseName; 
    private Instructor instructor; 
    private String university; 
    
    /**
     * //constructs a new course based on specified input
     * @param name
     * @param instructor
     * @param university
     */
    public Course(String name, Instructor instructor, String university) {
        this.courseName = name;
        this.instructor = instructor;
        this.university = university;
    }

    //constructs the default course with no specific input
    public Course() {
        this.courseName = "?";
        this.instructor = new Instructor();
        this.university = "?";
    }

    /**
     * 
     * @return current name of course
     */
    public String getName() {
        return courseName;
    }

    /**
     * @return instructor object
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * 
     * @return current university 
     */
    public String getUniversity() {
        return university;
    }

    /**
     * changes course name based on string input
     * @param newName
     */
    public void setName(String newName) {
        courseName = newName;
    }

    //changes the current instructor's paramaters with new ones
    public void setInstructor(String firstName, String lastName, String officeNumber) {
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setOfficeNumber(officeNumber);
    }

    /**
     * changes course's current university with new university based on string input
     * @param newUniversity
     */
    public void setUniversity(String newUniversity) {
        university = newUniversity;
    }

    /**
     * @return formatted string with course name, university, and instructor in a specific format
     */
    public String toString() {
        return "Course name:\t" + courseName + " at " + university + "\nInstructor Information:" + instructor;
    }


}
