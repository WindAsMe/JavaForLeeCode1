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
            set.add(process(e[0]) + "@" + e[1]);
        }
        for (String s : set)
            System.out.println(s);
        return set.size();
    }

    private static String process(String email) {
        StringBuilder s = new StringBuilder(email.split("\\+")[0]);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.')
                ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] emails = {"fg.r.u.uzj+o.pw@kziczvh.com",
                "r.cyo.g+d.h+b.ja@tgsg.z.com",
                "fg.r.u.uzj+o.f.d@kziczvh.com",
                "r.cyo.g+ng.r.iq@tgsg.z.com",
                "fg.r.u.uzj+lp.k@kziczvh.com",
                "r.cyo.g+n.h.e+n.g@tgsg.z.com",
                "fg.r.u.uzj+k+p.j@kziczvh.com",
                "fg.r.u.uzj+w.y+b@kziczvh.com",
                "r.cyo.g+x+d.c+f.t@tgsg.z.com",
                "r.cyo.g+x+t.y.l.i@tgsg.z.com",
                "r.cyo.g+brxxi@tgsg.z.com",
                "r.cyo.g+z+dr.k.u@tgsg.z.com",
                "r.cyo.g+d+l.c.n+g@tgsg.z.com",
                "fg.r.u.uzj+vq.o@kziczvh.com",
                "fg.r.u.uzj+uzq@kziczvh.com",
                "fg.r.u.uzj+mvz@kziczvh.com",
                "fg.r.u.uzj+taj@kziczvh.com",
                "fg.r.u.uzj+fek@kziczvh.com"
        };
        System.out.println(numUniqueEmailsResult(emails));
    }
}
