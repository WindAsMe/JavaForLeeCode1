import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : Dijkstra.java
 * Time       : Create on 19-5-13
 * Location   : ../Home/JavaForLeetCode/Dijkstra.java
 */
public class Dijkstra {

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

    private static int DijkstraResult(int[][] graph, int len) {
        int[] mark = new int[len];
        for (int i = 0; i < len; i++)
            mark[i] = -1;
        mark[0] = 0;
        for (int i = 0; i < len; i++) {
            if (graph[0][i] != -1) {
                mark[i] = mark[i] == -1 ? graph[0][i] : Math.min(graph[0][i], mark[i]);
                bfs(graph, mark, i);
            }
        }
        return mark[mark.length - 1];
    }

    private static void bfs(int[][] graph, int[] mark, int index) {
        for (int i = 0; i < mark.length; i++) {
            if (graph[index][i] != -1 && (mark[i] == -1 || Math.min(mark[index] + graph[index][i], mark[i]) < mark[i])) {
                mark[i] = mark[index] + graph[index][i];
                for (int j = 0; j < mark.length; j++) {
                    if (graph[j][i] != -1) {
                        bfs(graph, mark, i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Tuple> list = new ArrayList<>();
        list.add(new Tuple('A', 'B', 2));
        list.add(new Tuple('A', 'C', 5));
        list.add(new Tuple('C', 'B', 6));
        list.add(new Tuple('E', 'B', 3));
        list.add(new Tuple('D', 'B', 1));
        list.add(new Tuple('D', 'E', 4));
        list.add(new Tuple('C', 'F', 8));
        list.add(new Tuple('E', 'G', 9));
        list.add(new Tuple('F', 'G', 7));
        System.out.println(DijkstraResult(init(list, 7), 7));
    }
}
