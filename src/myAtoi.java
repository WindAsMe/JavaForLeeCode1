/**
 * Author     : WindAsMe
 * File       : myAtoi.java
 * Time       : Create on 18-7-19
 * Location   : ../Home/JavaForLeeCode/myAtoi.java
 * Function   : LeeCode No.8
 */
public class myAtoi {

    private static int myAtoiResult(String str) {
        String string = str.trim();
        char[] helper = string.toCharArray();
        StringBuilder s = new StringBuilder();
        // Flag to judge the '-'
        boolean flag = true;
        for (char c : helper) {
            if (c == '+') {
                if (flag)
                    flag = false;
                else
                    break;
            } else if (c == '-') {
                if (flag) {
                    s.append('-');
                    flag = false;
                }
                else
                    break;
            } else if (c >= '0' && c <= '9') {
                flag = false;
                s.append(c);
            } else
                break;
        }
        if (s.length() == 0 || (s.length() == 1 && s.charAt(0) == '-'))
            return 0;
        // Delete start '0'
        if (s.charAt(0) == '-') {
            while (s.charAt(1) == '0' && s.length() != 2)
                s.delete(1, 2);
        } else {
            while (s.charAt(0) == '0' && s.length() != 1)
                s.delete(0, 1);
        }
        System.out.println(s);
        if (s.length() > 15) {
            if (s.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        } else {
            Long l = Long.valueOf(s.toString());
            if (l > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (l < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return Integer.valueOf(s.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoiResult("-411-2"));
    }
}
