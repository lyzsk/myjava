package cn.sichu.myjava.october2021.dynamicprogramming;

/**
 * 376. 摆动序列 @see<a href = "https://leetcode-cn.com/problems/wiggle-subsequence/">376. 摆动序列</a>
 * <p>
 * 题目描述
 * <p>
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5]
 * 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 进阶:
 * <ul>
 * <li>你能否用 O(n) 时间复杂度完成此题?
 * </ul>
 * 解法
 * <p>
 * 设 up 表示以前 i 个元素中的某一个元素结尾的最长上升摆动序列的长度，down 表示以前 i 个元素中的某一个元素结尾的最长下降摆动序列的长度。初始 up = 1, down = 1。
 * <p>
 * 从数组下标 1 开始遍历：
 * <ul>
 * <li>若 nums[i] > nums[i - 1]，则需要更新最长上升摆动序列的长度：up = max(up, down + 1)
 * <li>若 nums[i] < nums[i - 1]，则需要更新最长下降摆动序列的长度：down = max(down, up + 1)
 * </ul>
 * 最后返回 max(up, down) 即可。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            }
            if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
            }
        }
        return Math.max(up, down);
    }
}
