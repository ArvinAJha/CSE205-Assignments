import java.io.Serializable;
import java.util.ArrayList;

public class CourseManager implements Serializable {
    
    public CourseManager() {
    }

    public void printList(ArrayList<Course> courseList) {
        for(int i = 0; i < courseList.size()-1; i++) {
            System.out.println(courseList.get(i).getName());

        }
    }

    //can sort the courses if you want


}
