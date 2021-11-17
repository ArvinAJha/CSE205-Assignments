package LinkedLists;

public class AssignmentLinkedList extends GradeLinkedList{

    public AssignmentLinkedList() {
        super();
    }
    public AssignmentLinkedList(int points, int totalPoints, String name) {
        super(points, totalPoints, name);
    }

    @Override
    public String toStringAtIndex(int pos) {
        return super.getNameAtPos(pos) + ": " + super.getValueAtPos(pos) + "/" + super.getTotalPointsAtPos(pos)
                + "(" + super.getValueAtPos(pos)/super.getTotalPointsAtPos(pos) + ")";
    }

    public void sortByName () {

    }

    //maybe change the toString methods as well but eh yknow 
    
}
