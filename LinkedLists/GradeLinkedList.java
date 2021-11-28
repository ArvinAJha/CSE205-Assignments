package LinkedLists;

import java.io.Serializable;

public class GradeLinkedList implements Serializable {
    private Grade head; //head of linked list
    private double numOfGrades;
    
    //****** private class for singular grade ******/
    private class Grade implements Serializable {
        private double value;      //what you got
        private double availablePoints; //what its out of
        private String name;
        private Grade next;

        //grade constructor
        public Grade(double valueObtained, double totalValue, String name, Grade link) {
            this.value = valueObtained;
            this.availablePoints = totalValue;
            this.name = name;
            next = link;
        }

    }
    //****** end of private class *****/

    //****** constructors *****/

    //create empty linked list
    public GradeLinkedList() {
        head = null;
        numOfGrades = 0;
    }
    
    //create initialized constructor
    public GradeLinkedList(double points, double totalPoints, String name) { //values of grade (what you got and total)
        head = new Grade(points, totalPoints, name, null);
        numOfGrades = 1;
    }

    /****** linked list methods *****/
    
    /**
     * add element to the end of the list
     * @param value
     * @param totalValue
     * @param name
     */
    public void add(double value, double totalValue, String name) {
        numOfGrades++;

        Grade newGrade = new Grade(value, totalValue, name, null);

        //if list is empty
        if(head == null) {
            head = newGrade;
        } else {
            Grade last = head;

            //iterate until you get to the last element 
            while(last.next != null) {
                last = last.next;
            }

            //add onto the next element after the last element
            last.next = newGrade;
        }
    }

    /**
     * remove element based on params
     * @param name
     * @param value
     * @param totalValue
     */
    public void remove(int index) {

        if(index < 0 || index >= numOfGrades) {  //throw ex when out of bounds
            System.out.println(index);
        }

        Grade previous = head;
        Grade current = head.next;
        int count = 1;

        if(index == 0 && head != null) {
            head = head.next;
            numOfGrades--;
        }

        while(count <= index) {
            previous = current;
            current = current.next;
            count++;

            if(count == index && current == null) {
                previous.next = null;
                numOfGrades--;
            } else if(count == index && current != null) {
                previous.next = current.next;
                numOfGrades--;
            }
        }
        
    }

    /**
     * returns default toString method for element in pos
     * @param pos
     * @return name \n value/points
     */
    public String toStringAtIndex(int pos) {
        Grade current = getAtIndex(pos);

        return current.name + ":\n" + current.value + "  /  " + current.availablePoints;
    }
    
    /**
     * 
     * @return if the element is empty
     */
    public boolean isEmpty() {
        return numOfGrades > 0;
    }
    
    public void printList() {
        for(int i = 0; i < getNumOfGrade(); i++) {
            System.out.println(toStringAtIndex(i));
        }
    }
    /* element varibale getters */
    /**
     * 
     * @param pos
     * @return name of element
     */
    public String getNameAtPos(int pos) {
        Grade current = getAtIndex(pos);

        return current.name;
    }

    /**
     * 
     * @param pos
     * @return points received at element
     */
    public double getValueAtPos(int pos) {
        Grade current = getAtIndex(pos);

        return current.value;
    }

    /**
     * 
     * @param pos
     * @return total points at element
     */
    public double getTotalPointsAtPos(int pos) {
        Grade current = getAtIndex(pos);

        return current.availablePoints;
    }

    /**
     * 
     * @return num of elements in the list
     */
    public double getNumOfGrade() {
        return numOfGrades;
    }

    /* calculations for a single type of grade */

    /**
     * calculates the sum of all the points recieved in all elements
     * @return sum of elements' points recieved
     */
    public double getGradeSum() {

        Grade current = head;
        double gradeSum = 0;

        //if list is empty, return 0
        if(current == null) {
            return 0;
        }
        while(current != null) {    //iterate through entire list up until last element and add all the values 
            gradeSum += current.value;
            current = current.next;
        }

        return gradeSum;
    }

    /**
     * sums all the available points
     * @return sum of elements' available points
     */
    public double getAvailablePointsSum() {
        Grade current = head;
        double gradeValueTotal = 0;
        if(current == null) {   //if empty, return 0
            return 0;
        }
        while(current != null) {    //iterate through list and add available points
            gradeValueTotal += current.availablePoints;
            current = current.next;
        }
        return gradeValueTotal;
    }
    
    /**
     * calculates grade for a single type of grade
     * @return points gotten sum / total points sum
     */
    public double calculateGrade() {

        if(this.getNumOfGrade() > 0) {  //if there are grades
            return this.getGradeSum() / this.getAvailablePointsSum();   //what you got / what was available
        }

        return 0;   //if there are no grades, return 0 to avoid exception
    }

    //helper methods
    /**
     * helper method used to get the element at a position
     * @param pos
     * @return Grade private class object
     */
    private Grade getAtIndex(int pos) {
        if(pos >= 0 && pos <= numOfGrades-1) {
            int count = 0; //temporary count 

            Grade current = head;

            //loop until find position
            while (count != pos) {
                current = current.next;
                count++;
            }

            return current;
        } else {
            System.out.println("getAtIndex (grade) is out of bounds!");
            return null;
        }
    }
}
