import java.util.Comparator;

/**
 * Assignment #7 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: The CourseNameComparator compares two Course object relative to their alphabetic placement
*/

public class CourseNameComparator implements Comparator <Course> {

    @Override
    //compare two Course names alphabetically
    public int compare(Course first, Course second) {

        return first.getCourseName().compareTo(second.getCourseName());

        
    }

    
}
