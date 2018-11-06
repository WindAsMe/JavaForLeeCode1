import java.util.Arrays;


/**
 * Author     : WindAsMe
 * File       : isAnagram.java
 * Time       : Create on 18-7-27
 * Location   : ../Home/JavaForLeeCode/isAnagram.java
 * Function   : LeeCode No.242
 */
public class isAnagram {

    private static boolean isAnagramResult(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] helper1 = s.toCharArray();
        char[] helper2 = t.toCharArray();
        Arrays.sort(helper1);
        Arrays.sort(helper2);
        for (int i = 0; i < helper1.length; i++) {
            if (helper1[i] != helper2[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagramResult( "anagram", "nagaram"));
    }
}
