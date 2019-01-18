import java.util.*;

/**
 * Author     : WindAsMe
 * File       : maxProduct.java
 * Time       : Create on 18-7-29
 * Location   : ../Home/JavaForLeeCode/maxProduct.java
 * Function   : LeeCode No.318
 */
public class maxProduct {

    private static int maxProductResult1(String[] words) {
        int size = words.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++)
            nums[i] = wordToNum(words[i]);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((nums[i] & nums[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private static int wordToNum(String string) {
        int result = 0;
        int size = string.length();
        for (int i = 0; i < size; i++)
            result |= 1 << (string.charAt(i) - 'a');
        return result;
    }

    // Brutal Proceeding: TL
    private static int maxProductResult(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (judge(words[i], words[j]))
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }

    private static boolean judge(String s1, String s2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++)
            list.add(s1.charAt(i));
        for (int i = 0; i < s2.length(); i++) {
            if (list.contains(s2.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProductResult1(s));
    }
}
