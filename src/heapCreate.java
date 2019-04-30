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

        public HeapNode(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

    }

    public static HeapNode HeapRecreateUp(HeapNode node) {
        if (node != null) {
            HeapNode heapNode = node;
            if (heapNode.left != null && heapNode.right != null) {
                if (heapNode.num <= heapNode.left.num && heapNode.num <= heapNode.right.num) {
                    HeapRecreateUp(heapNode.left);
                    HeapRecreateUp(heapNode.right);
                } else if (heapNode.num > heapNode.left.num) {
                    int temp = heapNode.num;
                    heapNode.num = heapNode.left.num;
                    heapNode.left.num = temp;
                    HeapRecreateUp(node);
                } else {
                    int temp = heapNode.num;
                    heapNode.num = heapNode.right.num;
                    heapNode.right.num = temp;
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

    public static void LayerIteration(HeapNode node) {
        Queue<HeapNode> queue1 = new PriorityQueue<>();
        Queue<HeapNode> queue2 = new PriorityQueue<>();
        if (node != null)
            queue1.add(node);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue1.isEmpty()) {
                HeapNode heapNode = queue1.poll();
                list.add(heapNode.getNum());
                if (heapNode.left != null)
                    queue2.add(heapNode.left);
                if (heapNode.right != null)
                    queue2.add(heapNode.right);
            }
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
            list.clear();
            while (!queue2.isEmpty()) {
                HeapNode heapNode = queue2.poll();
                list.add(heapNode.getNum());
                if (heapNode.left != null)
                    queue1.add(heapNode.left);
                if (heapNode.right != null)
                    queue1.add(heapNode.right);
            }
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
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
        HeapRecreateUp(node);
        LayerIteration(node);
    }


}
