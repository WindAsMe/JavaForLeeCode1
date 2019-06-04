import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : trie.java
 * Time       : Create on 19-6-4
 * Location   : ../Home/JavaForLeetCode/trie.java
 */
public class trie {

    static class TrieTree {
        boolean isContained;
        Character c;
        List<TrieTree> node;

        @Override
        public String toString() {
            return "TrieTree{" +
                    "isContained=" + isContained +
                    ", c=" + c +
                    ", node=" + node +
                    '}';
        }
    }

    private static TrieTree TrieTreeConstruct(String[] words) {
        TrieTree tree = new TrieTree();
        tree.node = new ArrayList<>();
        tree.isContained = false;
        tree.c = null;
        for (String s : words)
            TrieTreeWord(0, 0, s, tree.node);
        return tree;
    }

    private static void TrieTreeWord(int indexS, int indexList, String s, List<TrieTree> list) {
        if (indexS == s.length() - 1)
            list.get(indexList).isContained = true;
        for ()
    }

    private static int TrieTreeContain(List<TrieTree> list, Character c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).c == c)
                return i;
        }
        return -1;
    }

    private static void dfs(TrieTree tree) {
        if (tree.c != null) {
            System.out.println(tree.toString());
            for (TrieTree trieTree : tree.node)
                dfs(trieTree);
        }
    }

    public static void main(String[] args) {
        String[] words = {"abc", "abbc", "abb"};
        TrieTree tree = TrieTreeConstruct(words);

    }
}
