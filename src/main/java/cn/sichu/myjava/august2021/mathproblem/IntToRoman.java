package cn.sichu.myjava.august2021.mathproblem;

/**
 * 12. 整数转罗马数字@see<a href = "https://leetcode-cn.com/problems/integer-to-roman">整数转罗马数字</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L， C， D 和 M。。
 * <p>
 * 
 * <pre>
 * <strong>字符</strong>          <strong>数值</strong>
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </pre>
 * 
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为
 * IX。这个特殊的规则只适用于以下六种情况：
 * <ul>
 * <li>I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * <li>X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * <li>C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * </ul>
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 贪心算法实现
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
