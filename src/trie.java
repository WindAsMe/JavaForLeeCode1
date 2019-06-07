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

        TrieTree() {
        }

        TrieTree(Character c) {
            this.isContained = false;
            this.c = c;
        }

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
        for (String word : words)
            TrieTreeWord(0, word, tree);
        return tree;
    }

    private static void TrieTreeWord(int indexWord, String word, TrieTree tree) {
        if (indexWord == word.length() - 1) {
            tree.isContained = true;
            return;
        }
        List<TrieTree> list = tree.node;
        if (list == null || list.size() == 0) {
            tree.node = new ArrayList<>();
            tree.node.add(new TrieTree(word.charAt(indexWord)));
            TrieTreeWord(indexWord + 1, word, tree.node.get(0));
        } else if (TrieTreeIndex(word.charAt(indexWord), tree.node) == -1) {
            tree.node.add(new TrieTree(word.charAt(indexWord)));
            TrieTreeWord(indexWord + 1, word, tree.node.get(tree.node.size() - 1));
        } else {
            TrieTreeWord(indexWord + 1, word, tree.node.get(TrieTreeIndex(word.charAt(indexWord), tree.node)));
        }

    }

    private static int TrieTreeIndex(Character c, List<TrieTree> list) {
        for (int i = 0; i < list.size(); i++) {
            if (c == list.get(i).c)
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
        dfs(tree);
    }
}
