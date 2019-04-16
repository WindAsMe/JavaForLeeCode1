import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : shoppingOffers.java
 * Time       : Create on 19-4-16
 * Location   : ../Home/JavaForLeetCode/shoppingOffers.java
 * Function   : LeetCode No.638
 */
public class shoppingOffers {

    private static int shoppingOffersResult(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++)
            sum += price.get(i) * needs.get(i);
        for (List<Integer> list : special) {
            if (listJudge(list, needs)) {
                int total = list.get(list.size() - 1);
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++)
                    newNeeds.add(needs.get(i) - list.get(i));
                sum = Math.min(dfs(total, price, special, newNeeds), sum);
            }
        }
        return sum;
    }

    // l1.size() - l2.size() == 1
    private static boolean listJudge(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l2.size(); i++) {
            if (l2.get(i) < l1.get(i))
                return false;
        }
        return true;
    }

    private static boolean listZero(List<Integer> list) {
        for (int i : list) {
            if (i != 0)
                return false;
        }
        return true;
    }

    private static int dfs(int total, List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (listZero(needs))
            return total;
        for (List<Integer> list : special) {
            if (listJudge(list, needs)) {
                total += list.get(list.size() - 1);
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++)
                    newNeeds.add(needs.get(i) - list.get(i));
                total = Math.min(dfs(total, price, special, newNeeds), total);
            }
        }
        if (!listZero(needs)) {
            for (int i = 0; i < needs.size(); i++)
                total += price.get(i) * needs.get(i);
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);

        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> special1 = new ArrayList<>();
        special1.add(3);
        special1.add(0);
        special1.add(5);
        specials.add(special1);
        List<Integer> special2 = new ArrayList<>();
        special2.add(1);
        special2.add(2);
        special2.add(10);
        specials.add(special2);

        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);
        System.out.println(shoppingOffersResult(price, specials, needs));
    }
}
