/**
 * Author     : WindAsMe
 * File       : convertToBase7.java
 * Time       : Create on 18-8-4
 * Location   : ../Home/JavaForLeeCode/convertToBase7.java
 * Function   : LeeCode No.504
 */
public class convertToBase7 {

    private static String convertToBase7Result(int num) {
        StringBuilder s = new StringBuilder();
        if(num == 0)
            return "0";
        boolean flag = num <= 0;
        num = Math.abs(num);
        while(num != 0){
            s.insert(0,num % 7);
            num /= 7;
        }
        if(flag)
            s.insert(0,"-");

        return s.toString();
    }

    public static void main(String[] args) {
        int num = 54;
        System.out.println(convertToBase7Result(num));
    }

}
