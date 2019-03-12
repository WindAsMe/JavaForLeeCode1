/**
 * Author     : WindAsMe
 * File       : robotSim.java
 * Time       : Create on 18-7-22
 * Location   : ../Home/JavaForLeeCode/robotSim.java
 * Function   : LeeCode No.874
 */
public class robotSim {

    private static int robotSimResult(int[] commands, int[][] obstacles) {
        if (obstacles.length == 0) {
            int ans = 0;
            for (int a : commands) {
                if (a > 0)
                    ans += a * a;
            }
            return ans;
        } else {
            int x = 0;
            int y = 0;
            // 0: LEFT  1: UP  2: RIGHT  3: DOWN
            int toward = 1;
            for (int c : commands) {
                // Trans the toward
                if (c == -1) {
                    toward = (toward + 1) % 4;
                    continue;
                }
                if (c == -2) {
                    toward = (toward + 3) % 4;
                    continue;
                }

                // Left: y not change
                if (toward == 0) {
                    // If no obstacle the distance can move
                    int move = c;
                    for (int[] o : obstacles) {
                        if (o[1] == y && o[0] < x) {
                            if (x - o[0] <= move) {
                                move = x - o[0] - 1;
                            }
                        }
                    }
                    x -= move;
                    continue;
                }
                if (toward == 1) {
                    int move = c;
                    for (int[] o : obstacles) {
                        if (o[0] == x && o[1] > y) {
                            if (y + move >= o[1]) {
                                move = o[1] - y  - 1;
                            }
                        }
                    }
                    y += move;
                    continue;
                }
                if (toward == 2) {
                    int move = c;
                    for (int[] o : obstacles) {
                        if (o[1] == y && o[0] > x) {
                            if (x + move >= o[0]) {
                                move = o[0] - x - 1;
                            }
                        }
                    }
                    x += move;
                    continue;
                }
                if (toward == 3) {
                    int move = c;
                    for (int[] o : obstacles) {
                        if (o[0] == x && o[1] < y) {
                            if (y - move <= o[1]) {
                                move = y - o[1] - 1;
                            }
                        }
                    }
                    y -= move;
                }
            }
            return x * x + y * y;
        }
    }


    public static void main(String[] args) {
        int[] c = {2,5,2,5,-1,3,4,2,4,-2,5,8,-1,-2,-2,-1,8,-1,-2,-2,-1,-1,5,-1,-1,1,5,9,1,-1,-2,-1,-2,3,7,2,3,5,9,-2,5,2,1,4,6,5,9,1,9,6,3,-1,-1,9,9,-1,1,6,3,-2,2,2,5,-1,-1,-2,9,6,5,5,9,2,5,-2,-2,5,7,-1,-2,-1,2,-1,1,-1,-1,2,8,-1,8,3,-2,3,-1,-2,4,7,3,8,-1,2};
        int[][] o = {{-3, 0}};
        System.out.println(robotSimResult(c, o));
    }
}
