/**
 * Author     : WindAsMe
 * File       : addBinary.java
 * Time       : Create on 18-6-5
 * Location   : ../Home/JavaForLeeCode/addBinary.java
 * Function   : LeeCode No.67
 */
public class addBinary {

    private static String addBinaryResult(String a, String b) {
        String result = "";
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int sum = 0;
        while (aLen >= 0 || bLen >= 0) {
            if (aLen >= 0) {
                sum += Integer.parseInt(a.substring(aLen, aLen + 1));
                aLen --;
            }
            if (bLen >= 0) {
                sum += Integer.parseInt(b.substring(bLen, bLen + 1));
                bLen --;
            }
            if (sum == 2) {
                result = "0".concat(result) ;
                sum = 1;
            } else if(sum == 0 || sum == 1) {
                result = sum + "" + result;
                sum = 0;
            } else if(sum == 3){
                result = "1" + result;
                sum = 1;
            }
        }
        if(sum == 1)
            result = "1" + result;
        return result;
    }

    public static void main(String[] args) {
        String a = "101";
        String b = "11010";
        System.out.println(addBinaryResult(a, b));
    }
}

