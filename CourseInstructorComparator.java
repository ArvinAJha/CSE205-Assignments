// Assignment:
// Name:
// StudentID:
// Lecture:
// Description:

import java.util.Comparator;

public class CourseInstructorComparator implements Comparator<Course>
{   //complet the code. First compare the instructor's first name, if they are same, then compare
    //their last names. The courses should be listed in the alphabetical order of the
    //instructor's last and first names
    public int compare(Course first, Course second)
    {
       int comp = first.getInstructor().getLastName().compareTo(second.getInstructor().getLastName());

        if(comp == 0) {
            comp = first.getInstructor().getFirstName().compareTo(second.getInstructor().getFirstName());
            return comp;
        }

        return comp;

    }
}
