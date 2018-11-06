/**
 * Author     : WindAsMe
 * File       : countSegments.java
 * Time       : Create on 18-7-18
 * Location   : ../Home/JavaForLeeCode/countSegments.java
 * Function   : LeeCode No.434
 */
public class countSegments {

    private static int countSegmentsResult(String s) {
        char[] helper = s.toCharArray();
        int count = 0;
        boolean start = false;
        for (int i = 0; i < helper.length - 1; i ++) {
            if (start && ((helper[i] >= 'A' && helper[i] <= 'Z') || (helper[i] >= 'a' && helper[i] <= 'z'))) {
                if (!((helper[i + 1] >= 'A' && helper[i + 1] <= 'Z') || (helper[i + 1] >= 'a' && helper[i + 1] <= 'z')))
                    start = false;
            }
            if (!start && ((helper[i] >= 'A' && helper[i] <= 'Z') || (helper[i] >= 'a' && helper[i] <= 'z'))) {
                start = true;
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegmentsResult("Hello, my name is z"));
    }
}
