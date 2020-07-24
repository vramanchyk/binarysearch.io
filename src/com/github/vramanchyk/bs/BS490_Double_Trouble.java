package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS490_Double_Trouble {

    private List<String> states(int n, String state) {
        char[] chars = state.toCharArray();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == '1' && chars[i + 1] == '1') {
                chars[i] = chars[i + 1] = '0';
                result.add(new String(chars));
                chars[i] = chars[i + 1] = '1';
            }
        }
        return result;
    }

    private boolean win(int n, String state, Map<String, Boolean> dp) {
        if (dp.containsKey(state)) {
            return dp.get(state);
        }

        boolean win = false;
        for (String newState : states(n, state)) {
            if (!win(n, newState, dp)) {
                win = true;
                break;
            }
        }

        dp.put(state, win);
        return win;
    }

    public boolean solve(int[] nums) {
        String state = "";
        for (int num : nums) {
            state += num;
        }

        Map<String, Boolean> dp = new HashMap<>();
        return win(nums.length, state, dp);
    }
}
