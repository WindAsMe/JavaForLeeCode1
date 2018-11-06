
/**
 * Author     : WindAsMe
 * File       : judgeCircle.java
 * Time       : Create on 18-6-25
 * Location   : ../Home/JavaForLeeCode/judgeCircle.java
 * Function   : LeeCode No.657
 */
public class judgeCircle {

    private static boolean judgeCircleResult(String moves) {
        // (x, y) define the position
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i ++) {
            char temp = moves.charAt(i);
            if (temp == 'U') {
                y ++;
            } else if (temp == 'D') {
                y --;
            } else if (temp == 'L') {
                x --;
            } else {
                x ++;
            }

        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircleResult("LL"));
    }
}
