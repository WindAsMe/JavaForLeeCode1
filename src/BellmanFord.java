import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : BellmanFord.java
 * Time       : Create on 19-5-12
 * Location   : ../Home/JavaForLeetCode/BellmanFord.java
 */
public class BellmanFord {

    private static class Tuple {
        public char start;
        public char end;
        public int dis;

        public Tuple(char start, char end, int dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }
    }

    private static int[][] init(List<Tuple> list, int len) {
        int[][] graph = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++)
                graph[i][j] = -1;
        }
        for (Tuple tuple : list) {
            graph[tuple.start - 16][tuple.end - 16] = tuple.dis;
            graph[tuple.end - 16][tuple.start - 16] = tuple.dis;
        }
        return graph;
    }

    private static int BellmanFordResult(int[][] graph) {

    }

    public static void main(String[] args) {
        List<Tuple> list = new ArrayList<>();
        list.add(new Tuple('A', 'B', 9));
        list.add(new Tuple('A', 'C', 2));
        list.add(new Tuple('C', 'B', 6));
        list.add(new Tuple('E', 'B', 1));
        list.add(new Tuple('D', 'B', 3));
        list.add(new Tuple('D', 'E', 5));
        list.add(new Tuple('D', 'C', 2));
        list.add(new Tuple('D', 'F', 6));
        list.add(new Tuple('C', 'F', 9));
        list.add(new Tuple('E', 'F', 3));
        list.add(new Tuple('E', 'G', 7));
        list.add(new Tuple('F', 'G', 4));
        System.out.println(BellmanFordResult(init(list, 6)));
    }

}
