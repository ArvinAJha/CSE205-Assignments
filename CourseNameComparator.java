import java.util.Comparator;

public class CourseNameComparator implements Comparator <Course> {

    @Override
    public int compare(Course first, Course second) {

        return first.getCourseName().compareTo(second.getCourseName());

        
    }

    
}
