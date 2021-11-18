package LinkedLists;

public class TestLinkedList extends GradeLinkedList {

    public TestLinkedList() {
        super();
    }
    public TestLinkedList(int points, int totalPoints, String name) {
        super(points, totalPoints, name);
    }

    public void sort() {
        for(int i = 1; i < super.getNumOfGrade(); i++) {
            int key = super.getValueAtPos(i);
            int pos = i;
            while(pos > 0 && super.getValueAtPos(pos-1) > key) {
                //shift
                //data[pos] = data[pos-1]
                super.set(super.getAtIndex(pos-1), pos);
                pos--;
            }
            //set data[pos] = key
            super.set(super.getAtIndex(i), pos);
        }
    }

    public double calculateGrade(boolean lowestTestDropped) {
        if(lowestTestDropped) {
            super.printList();
            this.sort();
            super.printList();
            return (super.getGradeSum() - super.getValueAtPos(0)) / (super.getAvailablePointsSum() - super.getTotalPointsAtPos(0));

        }
        return super.calculateGrade();
    }
    
}