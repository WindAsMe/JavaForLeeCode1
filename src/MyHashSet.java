import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : MyHashSet.java
 * Time       : Create on 18-7-29
 * Location   : ../Home/JavaForLeeCode/MyHashSet.java
 * Function   : LeeCode No.705
 */
public class MyHashSet {

    /** Initialize your data structure here. */
    private List<Integer> list;
    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!list.contains(key))
            list.add(key);
    }

    public void remove(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key))
                list.remove(i);
        }
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
