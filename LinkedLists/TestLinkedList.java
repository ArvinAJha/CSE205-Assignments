package LinkedLists;

public class TestLinkedList extends GradeLinkedList {

    public TestLinkedList() {
        super();
    }
    public TestLinkedList(int points, int totalPoints, String name) {
        super(points, totalPoints, name);
    }

    public double calculateGrade(boolean lowestTestDropped) {
        if(lowestTestDropped) {
            //find lowest
            // return (super.getGradeSum() - super.getValueAtPos(0)) / (super.getAvailablePointsSum() - super.getTotalPointsAtPos(0));

        }
        return super.calculateGrade();
    }
    
}