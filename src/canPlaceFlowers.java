
/**
 * Author     : WindAsMe
 * File       : canPlaceFlowers.java
 * Time       : Create on 18-6-28
 * Location   : ../Home/JavaForLeeCode/canPlaceFlowers.java
 * Function   : LeeCode No.605
 */
public class canPlaceFlowers {

    private static boolean canPlaceFlowersResult(int[] flowerbed, int n) {
        if (flowerbed.length ==0) {
            return false;
        } else if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) {
                return n == 0;
            } else {
                return n <= 1;
            }
        }
        for (int i = 0; i < flowerbed.length; i ++) {
            if (i == 0) {
                if (flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    // plant
                    n--;
                    flowerbed[i] = 1;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    //plant
                    n--;
                    flowerbed[i] = 1;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    //plant
                    n --;
                    flowerbed[i] = 1;
                }
            }
        }
        //System.out.println(Arrays.toString(flowerbed));
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowered = {0};
        System.out.println(canPlaceFlowersResult(flowered, 1));
    }
}
