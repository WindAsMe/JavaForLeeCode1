import java.util.Arrays;
import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : longestValidParentheses.java
 * Time       : Create on 18-7-21
 * Location   : ../Home/JavaForLeeCode/longestValidParentheses.java
 * Function   : LeeCode No.32
 */
public class longestValidParentheses {

    // Result is the constant paren
    private static int longestValidParenthesesResult(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParenthesesResult("(()((()"));
    }
}
