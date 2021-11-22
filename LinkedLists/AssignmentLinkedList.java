package LinkedLists;

public class AssignmentLinkedList extends GradeLinkedList{

    public AssignmentLinkedList() {
        super();
    }
    public AssignmentLinkedList(double points, double totalPoints, String name) {
        super(points, totalPoints, name);
    }

    @Override
    public String toStringAtIndex(int pos) {
        return super.getNameAtPos(pos) + ": \n" + super.getValueAtPos(pos) + "/" + super.getTotalPointsAtPos(pos)
                + "  [" + super.getValueAtPos(pos)/super.getTotalPointsAtPos(pos) + "%]  ";
    }

    //maybe change the toString methods as well but eh yknow 
    
}
