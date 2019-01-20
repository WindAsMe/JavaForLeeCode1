/**
 * Author     : WindAsMe
 * File       : findPoisonedDuration.java
 * Time       : Create on 18-6-22
 * Location   : ../Home/JavaForLeeCode/findPoisonedDuration.java
 * Function   : LeeCode No.495
 */
public class findPoisonedDuration {

    private static int findPoisonedDurationResult(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration <= 0)
            return 0;
        else {
            int before = timeSeries[0];
            int total = duration;
            for (int i = 1; i < timeSeries.length; i++) {
                // Judge the next, current and duration
                if (timeSeries[i] >= before + duration) {
                    before = timeSeries[i];
                    total += duration;
                } else {
                    total += timeSeries[i] - before;
                    before = timeSeries[i];
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        int[] times = {1,2,3,4,5};
        System.out.println(findPoisonedDurationResult(times, 5));
    }
}
