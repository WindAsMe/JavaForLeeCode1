import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findRestaurant.java
 * Time       : Create on 18-6-28
 * Location   : ../Home/JavaForLeeCode/findRestaurant.java
 * Function   : LeeCode No.599
 */
public class findRestaurant {

    // 1.find restaurant and sum
    // 2.sort by sum
    // 3.add the corresponding
    private static String[] findRestaurantResult(String[] list1, String[] list2) {
        if (list1.length == 0 || list2.length == 0) {
            return new String[0];
        } else {
            // save the same restaurant
            // String[0]: restaurant
            // String[1]: index sum
            List<String[]> list = new ArrayList<>();
            // compare and add
            for (int i = 0; i < list1.length; i ++) {
                for (int j = 0; j < list2.length; j ++) {
                    if (list1[i].equals(list2[j])) {
                        String[] temp = new String[2];
                        temp[0] = list1[i];
                        temp[1] = String.valueOf(i + j);
                        list.add(temp);
                    }
                }
            }

            Collections.sort(list, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
            });
//            for (String[] aList : list) {
//                System.out.print(Arrays.toString(aList) + " ");
//            }
            int count = 1;
            for (int i = 1; i < list.size(); i ++) {
                if (list.get(i)[1].equals(list.get(0)[1])) {
                    count ++;
                } else {
                    break;
                }
            }
            String[] ans = new String[count];
            for (int i = 0; i < count; i ++) {
                ans[i] = list.get(i)[0];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurantResult(list1, list2)));
    }
}
