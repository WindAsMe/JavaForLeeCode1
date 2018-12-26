import java.util.Arrays;
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
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++)
                adjacency[i][graph[i][j]] = 1;
        }
        for (int[] g : graph)
            System.out.println(Arrays.toString(g));
        return null;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
        System.out.println(allPathsSourceTargetResult(graph));
    }
}
