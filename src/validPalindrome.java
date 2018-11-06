/**
 * Author     : WindAsMe
 * File       : validPalindrome.java
 * Time       : Create on 18-7-6
 * Location   : ../Home/JavaForLeeCode/validPalindrome.java
 * Function   : LeeCode No.680
 */
public class validPalindrome {

    // Most efficient: Recursion
    private static boolean validPalindromeResult2(String s) {
        return validPalindromeResult2(s, 0, s.length() - 1, 0);
    }

    private static boolean validPalindromeResult2(String s, int start, int end, int count) {
        if(count > 1) {
            return false;
        }
        if(start >= end) {
            return true;
        }
        if(s.charAt(start) == s.charAt(end)) {
            return validPalindromeResult2(s, start + 1, end - 1, count);
        } else {
            return validPalindromeResult2(s, start + 1, end, count + 1) || validPalindromeResult2(s, start, end - 1, count + 1);
        }
    }


    private static boolean validPalindromeResult1(String s) {
        char[] c = s.toCharArray();
        int i, j;
        int si = 0, sj = 0;
        int n = s.length();
        //if way reaches 2 and count is 1, when you find a different char, you return false
        int way = 0;
        for(i = 0, j = n - 1; i < j; i ++, j --) {
            if(c[i] != c[j]) {
                if(way == 2) {
                    return false;
                }
                if(way == 1) {
                    way ++;
                    i = si;
                    j = sj;
                    j ++;
                }
                if(way == 0){
                    way ++;
                    si = i;
                    sj = j;
                    i --;
                }
            }
        }
        return true;
    }


    // Brutal proceeding: TL
    private static boolean validPalindromeResult(String s) {
        char[] c = s.toCharArray();
        int begin = 0;
        int end = c.length - 1;
        while (begin < end) {
            if (c[begin] == c[end]) {
                begin ++;
                end --;
            } else {
                break;
            }
        }
        if (c[begin] == c[end] || begin == end) {
            return true;
        // Iteration the subtract element
        } else {
            // waiting to subtract element index
            int skip = 0;
            while (skip < c.length) {
                begin = 0;
                end = c.length - 1;
                while (begin < end) {
                    if (begin == skip) {
                        begin ++;
                    } else if (end == skip){
                        end --;
                    } else {
                        if (c[begin] == c[end]) {
                            begin ++;
                            end --;
                        } else {
                            break;
                        }
                    }
                }
                if (c[begin] == c[end] || begin == end) {
                    return true;
                } else {
                    skip ++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validPalindromeResult1("a"));
    }
}
