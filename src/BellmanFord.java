import java.util.ArrayList;
import java.util.Arrays;
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
            graph[tuple.start - 'A'][tuple.end - 'A'] = tuple.dis;
            graph[tuple.end - 'A'][tuple.start - 'A'] = tuple.dis;
        }
//        for (int[] g : graph)
//            System.out.println(Arrays.toString(g));
        return graph;
    }

    private static int BellmanFordResult(int[][] graph, int len) {
        int[] mark = new int[len];
        for (int i = 0; i < len; i++)
            mark[i] = -1;
        mark[0] = 0;
        while (true) {
            int[] temp = mark.clone();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (graph[i][j] != -1) {
                        if (mark[i] == -1 && mark[j] == -1)
                            continue;
                        else if (mark[i] == -1)
                            mark[i] = mark[j] + graph[i][j];
                        else if (mark[j] == -1)
                            mark[j] = mark[i] + graph[i][j];
                        else {
                            mark[i] = Math.min(mark[i], mark[j] + graph[i][j]);
                            mark[j] = Math.min(mark[j], mark[i] + graph[i][j]);
                        }
                    }
                }
            }
            if (Arrays.equals(temp, mark))
                break;
        }
        System.out.println(Arrays.toString(mark));
        return mark[mark.length - 1];
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
        System.out.println(BellmanFordResult(init(list, 7), 7));
    }

}
