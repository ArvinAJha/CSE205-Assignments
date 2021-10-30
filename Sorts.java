/**
 * Assignment #7 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: The Sorts class uses a selection sort to sort a list of courses with either the name comparator or the instructor
 *              comparator given the parameter
*/

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts
{
    public static void sort(ArrayList<Course> courseList, Comparator<Course> xComparator)
    {
        //write your code here (selection sort)
        int position;
        for(int index = 1; index < courseList.size(); index++) {
            Course key = courseList.get(index);
            position = index;
            
            while(position > 0 && xComparator.compare(courseList.get(position-1), key) > 0) {
                courseList.set(position, courseList.get(position-1));
                position--;
            }

            courseList.set(position, key);

        }
    } 
}
