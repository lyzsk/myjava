package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 45. 跳跃游戏 II @see<a href = "https://leetcode-cn.com/problems/jump-game-ii/">45. 跳跃游戏 II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 贪心。
 * 
 * @author sichu
 * @date 2021/09/07
 */
public class Jump {
    public int jump(int[] nums) {
        int end = 0;
        int max = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                steps += 1;
            }
        }
        return steps;
    }
}
