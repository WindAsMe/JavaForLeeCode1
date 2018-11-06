import java.util.HashMap;

/**
 * Author     : WindAsMe
 * File       : canIWin.java
 * Time       : Create on 18-7-18
 * Location   : ../Home/JavaForLeeCode/canIWin.java
 * Function   : LeeCode No.464
 */
public class canIWin {

    private static boolean canIWinResult(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0 || desiredTotal <= maxChoosableInteger)
            return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        char[] state = new char[maxChoosableInteger];
        for(int i = 0; i < maxChoosableInteger; i ++)
            state[i] = '0';
        return dfs(desiredTotal, state, new HashMap<>());
    }

    private static boolean dfs(int total, char[] state, HashMap<String, Boolean> hashMap) {
        String key= new String(state);
        if (hashMap.containsKey(key))
            return hashMap.get(key);
        for (int i = 0; i < state.length; i ++) {
            if (state[i] == '0') {
                state[i] = '1';
                if (total <= i + 1 || !dfs(total - (i + 1), state, hashMap)) {
                    hashMap.put(key, true);
                    state[i] = '0';
                    return true;
                }
                state[i] = '0';
            }
        }
        hashMap.put(key, false);
        return false;
    }

    public static void main(String[] args) {

    }
}
