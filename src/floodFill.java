import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : floodFill.java
 * Time       : Create on 18-7-15
 * Location   : ../Home/JavaForLeeCode/floodFill.java
 * Function   : LeeCode No.733
 */
public class floodFill {

    private static int[][] floodFillResult(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0)
            return image;
        int key = image[sr][sc];
        if (image[sr][sc] == newColor)
            return image;
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, key);
        dfs(image, sr + 1, sc, newColor, key);
        dfs(image, sr, sc - 1, newColor, key);
        dfs(image, sr, sc + 1, newColor, key);
        return image;
    }


    private static void dfs(int[][] image, int sr, int sc, int newColor, int key) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == key) {
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, key);
            dfs(image, sr + 1, sc, newColor, key);
            dfs(image, sr, sc - 1, newColor, key);
            dfs(image, sr, sc + 1, newColor, key);
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 0, 0},
                {1, 1, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 0;
        int[][] ans = floodFillResult(nums, sr, sc, newColor);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
