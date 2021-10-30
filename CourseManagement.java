// Assignment:
// Name:
// StudentID:
// Lecture:
// Description:


//import all necessary classes
import java.io.Serializable;
import java.util.ArrayList;

public class CourseManagement implements Serializable
{
    ArrayList<Course> courseList;



    /**
     * Create and instantiate the courseList
     */
    public CourseManagement()
    {
        //write code here
        courseList = new ArrayList<Course>();

    }

    /**
     * Search for a Course object in courseList by both its name and university.
     * Return the index of the object if it is found. Otherwise, return -1.
     * 
     * @param  courseName
     * @param  universityName
     * @return                the index of the Course object if found; -1
     *                        otherwise
     */
    public int courseExists(String courseName, String universityName)
    {
        //write code here

        for(int index = 0; index < courseList.size(); index++) {
            
            if(courseName.equals(courseList.get(index).getCourseName()) && universityName.equals(courseList.get(index).getUniversity())) {
                return index;
            }
        }

        return -1; //not found

    }

    /**
     * Search for an instructor in Course objects in the courseList that has the
     * same firstName, lastName, and officeNum info.
     * 
     * @param  firstName
     * @param  lastName
     * @param  officeNum
     * @return           the index of the Class object if found; -1 otherwise
     */
    public int instructorExists(String firstName, String lastName, String officeNum)
    {   //write the code here

        for(int index = 0; index < courseList.size(); index++) {
            
            if(lastName.equals(courseList.get(index).getInstructor().getLastName()) && firstName.equalsIgnoreCase(courseList.get(index).getInstructor().getFirstName()) && officeNum.equalsIgnoreCase(courseList.get(index).getInstructor().getOfficeNum())) {
                return index;
            }
        }

        return -1;

    }

    /**
     * Add a Course object to the courseList and return true if such an object
     * is added successfully. Otherwise, return false. Two Courses are
     * considered duplicated if they have exactly the same course name and
     * university name.
     * 
     * @param  courseName the course name
     * @param  university the university of the course
     * @param  firstName  the Instructor's first name
     * @param  lastName   the Instructor's last name
     * @param  officeNum  the Instructor's office number
     * @return            true if the operation is successful; false otherwise
     */
    public boolean addCourse(String courseName, String university, String firstName, String lastName, String officeNum)
    {
        if (courseExists(courseName, university) == -1)
        {
            Instructor courseInstructor = new Instructor(firstName, lastName, officeNum);
            Course newCourse = new Course(courseName, university, courseInstructor);
            courseList.add(newCourse);
            return true;
        }

        return false;
    }

    /**
     * Remove a Course object with the given course name and university name.
     * 
     * @param  courseName the course name
     * @param  university the university of the course
     * @return            true if the object is removed successfully; false if
     *                    the object does not exist.
     */
    public boolean removeCourse(String courseName, String university)
    {
        //write your code here
        if(courseExists(courseName, university) > -1) {
            courseList.remove(courseExists(courseName, university));
            return true;
        }

        return false;
    }

    /**
     * Sort the courseList by course names in alphabetical order. The method
     * calls the sort method in the Sorts class by using an object generated
     * from the CourseNameComparator class
     */
    public void sortByCourseName()
    {
        //write your code here
        Sorts.sort(courseList, new CourseNameComparator());

    }

    /**
     * Sort the courseList by Courses' instructors in the alphabetical order of
     * their last names and first names. The method calls the sort method
     * defined in the Sorts class by using an object generated from the
     * CourseInstructorComparator class.
     */
    public void sortByCourseInstructor()
    {
        Sorts.sort(courseList, new CourseInstructorComparator());
    }

    /**
     * List all Course objects in courseList.
     * 
     * @return
     */
    public String listCourses()
    {
        //write your code here
        String result = "";
        try {
            for(int index = 0; index < courseList.size(); index++) {
                result = result + courseList.get(index).toString();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("\nNo Courses Found\n");
        }

        return result; 
    }

    /**
     * Close the Course management system by making the courseList empty.
     */
    public void closeCourseManagement()
    {
       //write your code here
       courseList.clear();

    }

}
