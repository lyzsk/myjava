package cn.sichu.myjava.august2021.mathproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数 @see<a href = "https://leetcode-cn.com/problems/roman-to-integer">罗马数字转整数</a>
 * <p>
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> nums = new HashMap<>();
        nums.put("M", 1000);
        nums.put("CM", 900);
        nums.put("D", 500);
        nums.put("CD", 400);
        nums.put("C", 100);
        nums.put("XC", 90);
        nums.put("L", 50);
        nums.put("XL", 40);
        nums.put("X", 10);
        nums.put("IX", 9);
        nums.put("V", 5);
        nums.put("IV", 4);
        nums.put("I", 1);

        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && nums.get(s.substring(i, i + 2)) != null) {
                res += nums.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += nums.get(s.substring(i, i + 1));
                i += 1;
            }
        }
        return res;
    }
}
