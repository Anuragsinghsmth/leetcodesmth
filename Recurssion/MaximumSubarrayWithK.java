package Recurssion;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarrayWithK {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s.length() * k == 0) {
            return 0;
        }

        int i = 0, j = 0;
        int maxsub = 1;

        Map<Character, Integer> map = new HashMap();
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                maxsub = Math.max(maxsub, j - i + 1);
                j++;
            } else if (map.size() > k) {

                while (map.size() > k) {
                    int kk = map.get(s.charAt(i));
                    map.put(s.charAt(i), kk - 1);
                    if (kk == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }

        }

        return maxsub;

    }
}
