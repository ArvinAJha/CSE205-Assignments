public class Course {

    private String courseName; 
    private Instructor instructor; 
    private String university; 
    
    public Course(String name, Instructor instructor, String university) {
        this.courseName = name;
        this.instructor = instructor;
        this.university = university;
    }

    public Course() {
        this.courseName = "?";
        this.instructor = new Instructor();
        this.university = "?";
    }

    public String getName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getUniversity() {
        return university;
    }

    public void setName(String newName) {
        courseName = newName;
    }

    public void setInstructor(String firstName, String lastName, String officeNumber) {
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setOfficeNumber(officeNumber);
    }

    public void setUniversity(String newUniversity) {
        university = newUniversity;
    }

    public String toString() {
        return "Course name:\t" + courseName + " at " + university + "\nInstructor Information:" + instructor;
    }


}
