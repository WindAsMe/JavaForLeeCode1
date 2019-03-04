import java.util.*;

/**
 * Author     : WindAsMe
 * File       : ladderLength.java
 * Time       : Create on 18-7-25
 * Location   : ../Home/JavaForLeeCode/ladderLength.java
 * Function   : LeeCode No.127
 */
public class ladderLength {


    private static int ladderLengthResult1(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                if (temp != null && temp.equals(endWord))
                    return steps + 1;
                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String current = iterator.next();
                    if (canTransform(current, temp)) {
                        iterator.remove();
                        q.offer(current);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    private static boolean canTransform(String word1, String word2){
        for (int i = 0, count = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i) && ++count > 1)
                return false;
        }
        return true;
    }



    private static int ladderLengthResult(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            if (differ(wordList.get(i), beginWord) == 1) {
                // false: vacant
                boolean[] flag = new boolean[wordList.size()];
                flag[i] = true;
                bfs(1, wordList, wordList.get(i), endWord, flag, ans);
            }
        }
        return ans[0] == Integer.MAX_VALUE ? 0 : ans[0] + 1;
    }

    private static int differ(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                count++;
        }
        return count;
    }

    private static void bfs(int count, List<String> list, String current, String target, boolean[] flag, int[] ans) {
        if (current.equals(target)) {
            ans[0] = Math.min(count, ans[0]);
            return;
        }
        if (count == list.size())
            return;
        for (int i = 0; i < list.size(); i++) {
            if (!flag[i] && differ(list.get(i), current) == 1) {
                boolean[] copy = flag.clone();
                copy[i] = true;
                bfs(count + 1, list, list.get(i), target, copy, ans);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(ladderLengthResult1(beginWord, endWord, list));
    }
}
