/**
 * Author     : WindAsMe
 * File       : checkPerfectNumber.java
 * Time       : Create on 18-6-22
 * Location   : ../Home/JavaForLeeCode/checkPerfectNumber.java
 * Function   : LeeCode No.507
 */
public class checkPerfectNumber {

    private static boolean checkPerfectNumberResult(int num) {
        if(num == 0)
            return false;
        int n = (int) Math.sqrt(num);
        int ans = 1;
        for(int i = 2;i <= n;i++){
            // Add the corresponding two elements
            if(num % i == 0){
                ans += i + num / i;
            }
        }
        return ans == num;
    }

    // Bruise force: TL
//    private static boolean checkPerfectNumberResult(int num) {
//        if (num == 0) {
//            return false;
//        }
//        int count = 0;
//        for (int i = 1 ; i <= num / 2 ; i ++) {
//            if (num % i == 0) {
//                count += i;
//            }
//        }
//        System.out.println(count);
//        return count == num;
//    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumberResult(28));
    }
}
