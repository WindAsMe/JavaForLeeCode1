import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : constructRectangle.java
 * Time       : Create on 18-6-19
 * Location   : ../Home/JavaForLeeCode/constructRectangle.java
 * Function   : LeeCode No.492
 */
public class constructRectangle {

    private static int[] constructRectangleResult(int area) {
        int[] result = new int[2];
        int width = (int) Math.sqrt(area);
        int length = width;
        while (!(width * length == area)) {
            width++;
            length = area / width;
        }
        result[0] = width;
        result[1] = length;
        return result;
    }

    public static void main(String[] args) {
        int area = 16;
        System.out.println(Arrays.toString(constructRectangleResult(area)));
    }
}
