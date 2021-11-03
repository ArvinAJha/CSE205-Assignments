
public class AssignmentLinkedList {

    private Assignment head; //head of linked list
    private int numOfAssignments;
    private int assignmentSum;
    private int assignmentValueTotal;
    
    //****** private class for singular assignment ******/
    private class Assignment {
        private int value;      //what you got
        private int totalValue; //what its out of
        private String name;
        private Assignment next;

        //assignment constructor
        public Assignment(int valueObtained, int totalValue, String name, Assignment link) {
            this.value = valueObtained;
            this.totalValue = totalValue;
            this.name = name;
            next = link;
        }

    }
    //****** end of private class *****/

    //****** constructors *****/

    //create empty linked list
    public AssignmentLinkedList() {
        head = null;
        numOfAssignments = 0;
        assignmentSum = 0;
    }
    
    //create initialized constructor
    public AssignmentLinkedList(int data1, int data2, String name) { //values of assignment (what you got and total)
        head = new Assignment(data1, data2, name, null);
        numOfAssignments = 1;
        assignmentSum = 0;
    }

    //****** methods *****/

    //add assignment to front of list
    public void addToFront(int value, int totalValue, String name) {
        numOfAssignments++;

        Assignment newAssignment = new Assignment(value, totalValue, name, null);

        if(head == null) {  //list empty
            head = newAssignment;
        } else {
            newAssignment.next = head;
            head = newAssignment;
        }
    }
    
    //add assignment to end of list
    public void add(int value, int totalValue, String name) {
        numOfAssignments++;

        Assignment newAssignment = new Assignment(value, totalValue, name, null);

        if(head == null) {
            head = newAssignment;
        } else {
            Assignment last = head;

            while(last.next != null) {
                last = last.next;
            }

            last.next = newAssignment;
        }
    }

    public void remove (String name, int value, int totalValue) {
        if(head != null) {  //list isnt empty
            if(head.name.equalsIgnoreCase(name) && head.value == value && head.totalValue == totalValue) {  //if element is first 
                head = head.next;
                numOfAssignments--;
            } else {    //if element is not at the start
                Assignment previous = head;
                Assignment current = head.next;

                while(current != null && !current.name.equalsIgnoreCase(name) && head.value != value && head.totalValue != totalValue) {
                    previous = current;
                    current = current.next;
                }

                if(current != null) {   //check if whatever ended the loop is the element wanted
                    previous.next = current.next; //cut off current
                    numOfAssignments--;
                }
            }
        }
    }

    public boolean isEmpty() {
        return numOfAssignments > 0;
    }

    public Assignment getAtIndex(int pos) {
        if(pos >= 0 && pos <= numOfAssignments-1) {
            int count = 0; //temporary count 

            Assignment current = head;

            //loop until find position
            while (count != pos) {
                current = current.next;
                count++;
            }

            return current;
        } else {
            System.out.println("getAtIndex (assignment) is out of bounds!");
            return null;
        }
    }

    public void printList() { 
        Assignment current = head;

        while(current.next != null) {
            current = current.next;
            System.out.print("Name: " + current.name + "\nValue: " + current.name + "\nTotal Value: " + current.totalValue);
        }

        System.out.println();
    }

    public int getNumOfAssignment() {
        return numOfAssignments;
    }

    public int getAssignmentSum() { /** REMEMBER TO REST THE SUM WHEN U DELETE AN ASSIGNMENT OR RESET THE THING */
        Assignment current = head;

        while(current.next != null) {
            assignmentSum += current.value;
            current = current.next;
        }

        return assignmentSum;
    }

    public int getAssignmentValueTotal(String name) {   //searches for the correct assignment then gets the denom of it
        return 0;
    }
    
}
