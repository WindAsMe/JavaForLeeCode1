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
        for (String email : emails) {
            String[] e = email.split("@");
            set.add(process(e[0]) + e[1]);
        }

        for (String s : set)
            System.out.println(s);
        return set.size();
    }

    private static String process(String email) {
        System.out.println("process: " + email);
        StringBuilder s = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        String[] email1 = email.split("\\.");
        for (String e : email1)
            s.append(e);
        String[] email2 = s.toString().split("\\+");
        for (int i = 0; i < email2.length; i += 2)
            ans.append(email2[i]);
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmailsResult(emails));
    }
}
