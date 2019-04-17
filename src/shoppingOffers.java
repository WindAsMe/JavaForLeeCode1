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
                int a = dfs(total, price, special, newNeeds);
                System.out.println("a: " + a);
                sum = Math.min(a, sum);
            }
        }
        return sum;
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
                if (listZero(newNeeds))
                    return total;
                total = Math.min(dfs(total, price, special, newNeeds), total);
            }
        }
        if (!listZero(needs)) {
            for (int i = 0; i < needs.size(); i++)
                total += price.get(i) * needs.get(i);
        }
        return total;
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

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(9);
        price.add(9);

        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> special1 = new ArrayList<>();
        special1.add(1);
        special1.add(1);
        special1.add(1);
        specials.add(special1);

        List<Integer> needs = new ArrayList<>();
        needs.add(6);
        needs.add(6);
        System.out.println(shoppingOffersResult(price, specials, needs));
    }
}
