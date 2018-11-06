/**
 * Author     : WindAsMe
 * File       : canCompleteCircuit.java
 * Time       : Create on 18-7-26
 * Location   : ../Home/JavaForLeeCode/canCompleteCircuit.java
 * Function   : LeeCode No.134
 */
public class canCompleteCircuit {

    private static int canCompleteCircuitResult(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0)
            return -1;
        int total = 0;
        int cur = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++){
            total += gas[i]- cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0){
                cur = 0;
                res = i + 1;
            }
        }
        return total >= 0 ? res : -1;
    }

    public static void main(String[] args) {
        int[] gas  = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuitResult(gas, cost));

    }
}
