/**
 * Author     : WindAsMe
 * File       : countBinarySubstrings.java
 * Time       : Create on 18-7-4
 * Location   : ../Home/JavaForLeeCode/countBinarySubstrings.java
 * Function   : LeeCode No.696
 */
public class countBinarySubstrings {

    public int countBinarySubstrings2(String s) {
        int len = s.length();
        if(len <= 1)
            return 0;
        // Trans the String to Array is more efficient
        char[] sc = s.toCharArray();
        int i = 0, prev = -1, res = 0;
        while (i < len) {
            int j = i;
            char c = sc[i];
            while (i < len && sc[i]==c) i ++;
            int cur = i - j;
            if (prev != -1) res += Math.min(prev, cur);
            prev = cur;
        }
        return res;
    }

    // Trans the String like "1001011101"
    // To arr[] = {1,2,1,1,3,1,1}
    // The consecutive occurrence
    private static int countBinarySubstringsResult1(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            int [] count = new int[s.length()];
            int tmp = 0;
            for(int i = 0; i < s.length() - 1; i ++){
                count[tmp] ++;
                if(s.charAt(i) != s.charAt(i + 1))
                    tmp ++;
            }
            if(s.length() > 1 && s.charAt(s.length() - 1) == s.charAt(s.length() - 2))
                count[tmp] ++;
            else
                count[tmp] ++;

            int res = 0;
            for(int i = 0; i < tmp; i ++){
                res += Math.min(count[i], count[i + 1]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstringsResult1("100110"));
    }
}
