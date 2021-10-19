public class TestReverse {

    public static void show(int[] x, int n) {
        System.out.print("[ ");
        for(int i = 0; i < n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
        show(x, x.length);
        reverseArray(x, 0, x.length-1);
        show(x, x.length);
    }
    public static void reverseArray(int[] x, int start, int end) {
        if(start < end) {
            int temp = x[end];
            x[end] = x[start];
            x[start] = temp;
            reverseArray(x, start+1, end-1);
        }
    }
}
