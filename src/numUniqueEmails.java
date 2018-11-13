import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : numUniqueEmails.java
 * Time       : Create on 18-11-13
 * Location   : ../Home/JavaForLeetCode/numUniqueEmails.java
 * Function   : LeetCode No.929
 */
public class numUniqueEmails {

    private static int numUniqueEmailsResult(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails)
            set.add(process(email));

        for (String s : set)
            System.out.println(s);
        return set.size();
    }

    private static String process(String email) {
        StringBuilder s = new StringBuilder(email);
        StringBuilder temp = new StringBuilder();
        int i = 0;
        for (; s.charAt(i) != '@'; i++) {
            if (s.charAt(i) == '.') {
                continue;
            } else if (s.charAt(i) == '+') {
                temp = new StringBuilder();
            } else {
                temp.append(s.charAt(i));
            }
        }
        return temp.append(s.substring(i, s.length())).toString();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmailsResult(emails));
    }
}
