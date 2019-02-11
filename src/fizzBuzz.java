import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : fizzBuzz.java
 * Time       : Create on 18-6-23
 * Location   : ../Home/JavaForLeeCode/fizzBuzz.java
 * Function   : LeeCode No.412
 */
public class fizzBuzz {

    private static List<String> fizzBuzzResult(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1 ; i <= n ; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                list.add("FizzBuzz");
            else if (i % 3 == 0)
                list.add("Fizz");
            else if (i % 5 == 0)
                list.add("Buzz");
            else
                list.add(String.valueOf(i));
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> l = fizzBuzzResult(n);
        for (String aL : l) {
            System.out.print(aL + " ");
        }
    }
}
