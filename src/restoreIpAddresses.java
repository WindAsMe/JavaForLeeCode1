import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : restoreIpAddresses.java
 * Time       : Create on 18-7-24
 * Location   : ../Home/JavaForLeeCode/restoreIpAddresses.java
 * Function   : LeeCode No.93
 */
public class restoreIpAddresses {

    private static List<String> restoreIpAddressesResult(String s) {
        List<String> list = new ArrayList<>();
        addDot(list, s,"", 3);
        return list;
    }
    private static void addDot(List<String> list, String s,String result, int k){
        if (s.length() <= k)
            return;
        if (s.length() > 3 * (k + 1))
            return;
        if (k == 0) {
            if ((s.charAt(0) == '0' && s.length() > 1 ) || Integer.parseInt(s) >= 256)
                return;
            list.add(result + "." + s);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (Integer.parseInt(temp) < 256) {
                String str = s.substring(i);
                if (result.length() > 0)
                    temp = result + "." + temp;
                addDot(list, str, temp, k - 1);
                if (s.charAt(0) == '0')
                    break;
            } else
                break;
        }
    }


    public static void main(String[] args) {
        List<String> list = restoreIpAddressesResult("0000");
        for (String s : list)
            System.out.println(s);
    }
}
