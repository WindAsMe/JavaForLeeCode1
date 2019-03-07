import java.util.HashSet;

/**
 * Author     : WindAsMe
 * File       : validSquare.java
 * Time       : Create on 18-6-30
 * Location   : ../Home/JavaForLeeCode/validSquare.java
 * Function   : LeeCode No.593
 */
public class validSquare {

    private static boolean validSquareResult1(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        int d1 = distance(p1, p2);
        int d2 = distance(p1, p3);
        int d3 = distance(p1, p4);
        int d4 = distance(p2, p3);
        int d5 = distance(p2, p4);
        int d6 = distance(p3, p4);
        if (d1 == 0 || d2 == 0 || d3 == 0 || d4 == 0 || d5 == 0 || d6 == 0)
            return false;
        set.add(d1);
        set.add(d2);
        set.add(d3);
        set.add(d4);
        set.add(d5);
        set.add(d6);
        return set.size() == 2;
    }

    private static int distance(int[] x, int[] y) {
        return (int) (Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }


    // set p1 as benchmark
    // If can constitute as square:
    // 3 line can constitute as special triangle
    private static boolean validSquareResult(int[] p1, int[] p2, int[] p3, int[] p4) {
        double length1 = Math.pow(p2[1] - p1[1], 2) + Math.pow(p2[0] - p1[0], 2);
        double length2 = Math.pow(p3[1] - p1[1], 2) + Math.pow(p3[0] - p1[0], 2);
        double length3 = Math.pow(p4[1] - p1[1], 2) + Math.pow(p4[0] - p1[0], 2);
        if (length1 == 0 || length2 == 0 || length3 == 0)
            return false;
        else {
            // If the axis is not parallel or vertical
            int point1_row = p4[0] - p2[0];
            int point1_column = p4[1] - p2[1];
            int point2_row = p3[0] - p1[0];
            int point2_column = p3[1] - p1[1];
            if (length1 + length2 == length3 || length1 + length3 == length2 || length3 + length2 == length1) {
                return length1 == length2 || length1 == length3 || length2 == length3;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] p1 = {0, 1};
        int[] p2 = {1, 0};
        int[] p3 = {0, -1};
        int[] p4 = {-1, 0};
        System.out.println(validSquareResult(p1, p2, p3, p4));
    }
}
