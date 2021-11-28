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
        if(lowestTestDropped && super.getNumOfGrade() > 1) {
            int lowestPos = getLowest(0, 0);
            // System.out.println(lowestPos);
            return (super.getGradeSum() - super.getValueAtPos(lowestPos)) / (super.getAvailablePointsSum() - super.getTotalPointsAtPos(lowestPos));

        }
        return super.calculateGrade();  //default calculation if var is false
    }

    public double calculateGrade(double points, double totalPoints) {
        return (super.getGradeSum() + points) / (super.getAvailablePointsSum() + totalPoints);
    }

    /**
     * recursive method to find the lowest scoring grade
     * @param minPos send in as a default 0 always to start at beginning
     * @param pos send in as a default 0 always to start at beginning
     * @return the index of the lowest scoring grade
     */
    private int getLowest(int minPos, int pos) {

        /**
         * base case: must be size() and not size() - 1 because the base case will stop the recursion before it runs through the last element
         * it will stop immediately when the base case is reached, not checked. Therefore, you must stop the base case one more so all elements
         * are checked
         */
        if(pos == super.getNumOfGrade()) {
            return minPos;
        } else {
            //if the checking position is lower than the current lowest
            if(super.getValueAtPos(pos) < super.getValueAtPos(minPos)) {
                //set the current position to the new lowest and iterate
                return getLowest(pos, pos+1);
            } else {
                //else just iterate
                return getLowest(minPos, pos+1);
            }
        }
    }
    
}