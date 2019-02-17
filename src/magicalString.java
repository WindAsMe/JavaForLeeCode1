/**
 * Author     : WindAsMe
 * File       : magicalString.java
 * Time       : Create on 19-1-2
 * Location   : ../Home/JavaForLeetCode/magicalString.java
 * Function   : LeetCode No.481
 */
public class magicalString {

    private static int magicalStringResult(int n) {
        if(n <= 0)
            return 0;
        if(n <= 3)
            return 1;
        StringBuilder base = new StringBuilder("122");
        StringBuilder sub = new StringBuilder("12");
        int counts = 1;
        int index, temp;
        while (base.length() < n) {
            index = sub.length();
            temp = base.charAt(index) - '0';
            sub.append(temp);
            if (temp == 2) {
                temp = base.charAt(base.length() - 1) - '0';
                if (temp == 2) {
                    base.append("11");
                    if (base.length() <= n)
                        counts += 2;
                    else
                        counts += 1;
                } else
                    base.append("22");
            } else {
                temp = base.charAt(base.length() - 1) - '0';
                if (temp == 2) {
                    base.append("1");
                    counts += 1;
                } else
                    base.append("2");
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(magicalStringResult(n));
    }
}
