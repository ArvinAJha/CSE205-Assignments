package LinkedLists;

import java.io.Serializable;

public class GradeLinkedList implements Serializable {
    private Grade head; //head of linked list
    private double numOfGrades;
    // private double gradeSum;
    // private double gradeValueTotal;
    
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

    //****** methods *****/

    //add grade to front of list
    public void addToFront(double value, double totalValue, String name) {
        numOfGrades++;

        Grade newGrade = new Grade(value, totalValue, name, null);

        if(head == null) {  //list empty
            head = newGrade;
        } else {
            newGrade.next = head;
            head = newGrade;
        }
    }
    
    //add grade to end of list
    public void add(double value, double totalValue, String name) {
        numOfGrades++;

        Grade newGrade = new Grade(value, totalValue, name, null);

        if(head == null) {
            head = newGrade;
        } else {
            Grade last = head;

            while(last.next != null) {
                last = last.next;
            }

            last.next = newGrade;
        }
    }

    public void remove(String name, double value, double totalValue) {

        if(head != null) {  //list isnt empty
            if(head.name.equalsIgnoreCase(name) && head.value == value && head.availablePoints == totalValue) {  //if element is first 
                head = head.next;
                numOfGrades--;
            } else {    //if element is not at the start
                Grade previous = head;
                Grade current = head.next;

                while(current != null && !current.name.equalsIgnoreCase(name) && current.value != value && current.availablePoints != totalValue) {
                    previous = current;
                    current = current.next;
                }

                if(current != null) {   //check if whatever ended the loop is the element wanted
                    previous.next = current.next; //cut off current
                    numOfGrades--;
                }
            }
        }
    }

    public Grade getAtIndex(int pos) {
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

    public String toStringAtIndex(int pos) {
        Grade current = getAtIndex(pos);

        return current.name + ":\n" + current.value + "  /  " + current.availablePoints;
    }

    public String getNameAtPos(int pos) {
        Grade current = getAtIndex(pos);

        return current.name;
    }

    public double getValueAtPos(int pos) {
        Grade current = getAtIndex(pos);

        return current.value;
    }

    public double getTotalPointsAtPos(int pos) {
        Grade current = getAtIndex(pos);

        return current.availablePoints;
    }

    public void printList() { 
        Grade current = head;

        while(current != null) {
            System.out.print("\nName: " + current.name + "\nValue: " + current.name + "\nTotal Value: " + current.availablePoints);
            current = current.next;
        }

        System.out.println();
    }

    public double getNumOfGrade() {
        return numOfGrades;
    }

    public boolean isEmpty() {
        return numOfGrades > 0;
    }

    public double getGradeSum() { /** REMEMBER TO REST THE SUM WHEN U DELETE AN GRADE OR RESET THE THING */
        Grade current = head;
        double gradeSum = 0;
        if(current == null) {
            return 0;
        }
        while(current != null) {
            gradeSum += current.value;
            current = current.next;
        }

        return gradeSum;
    }

    public double getAvailablePointsSum() {       //calculates the stuff for the bottom of the grade fraction
        //should be avaible value + available value ... until they have all been added
        Grade current = head;
        double gradeValueTotal = 0;
        if(current == null) {
            return 0;
        }
        while(current != null) {
            gradeValueTotal += current.availablePoints;
            current = current.next;
        }
        return gradeValueTotal;
    }
    
    public double calculateGrade() {
        if(this.getNumOfGrade() > 0) {
            return this.getGradeSum() / this.getAvailablePointsSum();
        }

        return 0;
    }
}
