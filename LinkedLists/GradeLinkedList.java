package LinkedLists;

public class GradeLinkedList {
    private Grade head; //head of linked list
    private int numOfGrades;
    private int gradeSum;
    private int gradeValueTotal;
    
    //****** private class for singular grade ******/
    private class Grade {
        private int value;      //what you got
        private int availablePoints; //what its out of
        private String name;
        private Grade next;

        //grade constructor
        public Grade(int valueObtained, int totalValue, String name, Grade link) {
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
        gradeSum = 0;
    }
    
    //create initialized constructor
    public GradeLinkedList(int points, int totalPoints, String name) { //values of grade (what you got and total)
        head = new Grade(points, totalPoints, name, null);
        numOfGrades = 1;
        gradeSum = 0;
    }

    //****** methods *****/

    //add grade to front of list
    public void addToFront(int value, int totalValue, String name) {
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
    public void add(int value, int totalValue, String name) {
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

    public void remove (String name, int value, int totalValue) {
        if(head != null) {  //list isnt empty
            if(head.name.equalsIgnoreCase(name) && head.value == value && head.availablePoints == totalValue) {  //if element is first 
                head = head.next;
                numOfGrades--;
            } else {    //if element is not at the start
                Grade previous = head;
                Grade current = head.next;

                while(current != null && !current.name.equalsIgnoreCase(name) && head.value != value && head.availablePoints != totalValue) {
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

    public boolean isEmpty() {
        return numOfGrades > 0;
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

    public void printList() { 
        Grade current = head;

        while(current.next != null) {
            current = current.next;
            System.out.print("Name: " + current.name + "\nValue: " + current.name + "\nTotal Value: " + current.availablePoints);
        }

        System.out.println();
    }

    public int getNumOfGrade() {
        return numOfGrades;
    }

    public int getGradeSum() { /** REMEMBER TO REST THE SUM WHEN U DELETE AN GRADE OR RESET THE THING */
        Grade current = head;
        if(current == null) {
            return 0;
        }
        while(current.next != null) {
            gradeSum += current.value;
            current = current.next;
        }

        return gradeSum;
    }

    public int getAvailablePointsSum() {       //calculates the stuff for the bottom of the grade fraction
        //should be avaible value + available value ... until they have all been added
        Grade current = head;
        if(current == null) {
            return 0;
        }
        while(current.next != null) {
            gradeValueTotal += current.availablePoints;
            current = current.next;
        }
        return gradeValueTotal;
    }

}
