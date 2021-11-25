package LinkedLists;

public class TestLinkedList extends GradeLinkedList {

    public TestLinkedList() {
        super();
    }
    public TestLinkedList(int points, int totalPoints, String name) {
        super(points, totalPoints, name);
    }

    /**
     * if the lowest test is supposed to be dropped then find the smallest value you recieved and substract from sum
     * @param lowestTestDropped
     * @return grade calulcated 
     */
    public double calculateGrade(boolean lowestTestDropped) {
        if(lowestTestDropped) {
            int lowestPos = getLowest(0, 0);
            return (super.getGradeSum() - super.getValueAtPos(lowestPos)) / (super.getAvailablePointsSum() - super.getTotalPointsAtPos(lowestPos));

        }
        return super.calculateGrade();  //default calculation if var is false
    }

    //recurseive method
    private int getLowest(int minPos, int pos) {
        if(pos == super.getNumOfGrade()-1) {
            return minPos;
        } else {
            if(super.getValueAtPos(pos) < super.getValueAtPos(minPos)) {
                return getLowest(pos, pos+1);
            } else {
                return getLowest(minPos, pos+1);
            }
        }
    }
    
}