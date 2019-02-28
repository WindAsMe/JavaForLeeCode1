import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : generateParenthesis.java
 * Time       : Create on 18-7-9
 * Location   : ../Home/JavaForLeeCode/generateParenthesis.java
 * Function   : LeeCode No.22
 */
public class generateParenthesis {


    private static List<String> generateParenthesisResult(int n) {
        List<String> list = new ArrayList<>();
        generateParen(n - 1, n, "(", list);
        return list;
    }

    //
    private static void generateParen(int left, int right, String s, List<String> list) {
        //System.out.println(1);
        if (left >= 0 && right >= 0) {
            if (left == right) {
                if (left == 0)
                    list.add(s);
                else
                    generateParen(left - 1, right, s + "(", list);
            }
            if (left < right) {
                generateParen(left - 1, right, s + "(", list);
                generateParen(left, right - 1, s + ")", list);
            }
        }
    }




    private static List<String> generateParenthesisResult1(int n) {
        List<String> list = new ArrayList<>();
        generate(n, n, "", list);
        return list;
    }

    // In recursion
    private static void generate(int left, int right, String str, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        } if (left > right)
            return;
        if (left > 0)
            generate(left - 1, right, str + "(", list);
        if (right > 0)
            generate(left, right - 1, str + ")", list);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesisResult(n).toString());
    }
}
