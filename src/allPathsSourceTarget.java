import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : allPathsSourceTarget.java
 * Time       : Create on 18-12-26
 * Location   : ../Home/JavaForLeetCode/allPathsSourceTarget.java
 * Function   : LeetCode No.797
 */
public class allPathsSourceTarget {

    private static List<List<Integer>> allPathsSourceTargetResult(int[][] graph) {
        int[][] adjacency = new int[graph.length][graph.length];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++)
                adjacency[i][graph[i][j]] = 1;
        }
        for (int i = 1; i < graph.length; i++) {
            if (adjacency[0][i] == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                recursion(adjacency, lists, list, i);
            }
        }
        return lists;
    }

    private static void recursion(int[][] adjacency, List<List<Integer>> lists, List<Integer> list, int last) {
        int end = adjacency.length - 1;
        if (last == end) {
            list.add(last);
            lists.add(list);
        } else if (list.size() < end) {
            list.add(last);
            for (int i = 1; i < adjacency.length; i++) {
                if (adjacency[last][i] == 1) {
                    List<Integer> l = new ArrayList<>(list);
                    recursion(adjacency, lists, l, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {3},
                {3},
                {}
        };
        System.out.println(allPathsSourceTargetResult(graph));
    }
}
