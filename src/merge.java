import java.util.*;

/**
 * Author     : WindAsMe
 * File       : merge.java
 * Time       : Create on 18-7-12
 * Location   : ../Home/JavaForLeeCode/merge.java
 * Function   : LeeCode No.56
 */
public class merge {

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // This function more brutal.
    // Separate the start and end
    // Directly sort and connect
    public List<Interval> mergeResult1(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;

    }

    // This function didn't break the structures
    private static List<Interval> mergeResult(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() < 2)
            return intervals;
        // sort depending the a.start
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for (Interval a : intervals)
            System.out.println("( " + a.start + ", " + a.end + " )");
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            if (interval.start <= end)
                end = Math.max(end, interval.end);
            else{
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,4));
        list.add(new Interval(2,5));
        list.add(new Interval(-1, 1));
        list.add(new Interval(3,4));
        list.add(new Interval(6,9));
//        List<Interval> list = new ArrayList<>();
//        list.add(new Interval(1,3));
//        list.add(new Interval(2,6));
//        list.add(new Interval(8, 10));
//        list.add(new Interval(15,18));
        List<Interval> list1 = mergeResult(list);

    }
}
