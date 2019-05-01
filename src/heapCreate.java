import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author     : WindAsMe
 * File       : heapCreate.java
 * Time       : Create on 19-4-30
 * Location   : ../Home/JavaForLeetCode/heapCreate.java
 */
public class heapCreate {

    public static class HeapNode {
        private HeapNode left;
        private HeapNode right;
        private int num;

        HeapNode(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

    }

    private static HeapNode HeapRecreateUp(HeapNode node) {
        if (node != null) {
            if (node.left != null && node.right != null) {
                if (node.num <= node.left.num && node.num <= node.right.num) {
                    HeapRecreateUp(node.left);
                    HeapRecreateUp(node.right);
                } else if (node.num > node.left.num) {
                    int temp = node.num;
                    node.num = node.left.num;
                    node.left.num = temp;
                    HeapRecreateUp(node);
                } else {
                    int temp = node.num;
                    node.num = node.right.num;
                    node.right.num = temp;
                    HeapRecreateUp(node);
                }

            }
            return node;
        }
        return null;
    }

    public static HeapNode HeapRecreateDown(HeapNode node) {
        return node;
    }

    private static void LayerIteration(HeapNode node) {
        if (node != null) {
            System.out.print(node.num + " ");
            LayerIteration(node.left);
            LayerIteration(node.right);
        }
    }

    public static void main(String[] args) {
        HeapNode node = new HeapNode(1);
        node.left = new HeapNode(3);
        node.left.left = new HeapNode(4);
        node.left.right = new HeapNode(8);

        node.right = new HeapNode(6);
        node.right.left = new HeapNode(7);
        node.right.right = new HeapNode(5);
        LayerIteration(node);
        node = HeapRecreateUp(node);
        System.out.println();
        LayerIteration(node);
    }


}
