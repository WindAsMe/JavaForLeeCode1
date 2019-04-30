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
            if (node.left != null && node.right != null) {
                if (node.num <= node.left.num && node.num <= node.right.num) {
                    HeapRecreateUp(node.left);
                    HeapRecreateUp(node.right);
                } else if ()

            }
            return node;
        }
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
                queue2.add(heapNode.left);
                queue2.add(heapNode.right);
            }
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
            list.clear();
            while (!queue2.isEmpty()) {
                HeapNode heapNode = queue2.poll();
                list.add(heapNode.getNum());
                queue1.add(heapNode.left);
                queue1.add(heapNode.right);
            }
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }




}
