package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 740. 删除与获得点数 @see<a href = "https://leetcode-cn.com/problems/delete-and-earn/">740. 删除与获得点数</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1:
 * 
 * <pre>
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * </pre>
 * 
 * 示例 2:
 * 
 * <pre>
 * 输入: nums = [2, 2, 3, 3, 3, 4] 输出: 9 解释: 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。 总共获得 9
 * 个点数。
 * </pre>
 * 
 * <strong>注意:</strong>
 * <ul>
 * <li>nums的长度最大为20000。
 * <li>每个整数nums[i]的大小都在[1, 10000]范围内。
 * </ul>
 * <strong>解法</strong>
 * <p>
 * 核心思路: 一个数字要么不选，要么全选
 * <p>
 * 首先计算出每个数字的总和 sums，并维护两个 dp 数组：select 和 nonSelect
 * <ul>
 * <li>sums[i] 代表值为 i 的元素总和
 * <li>select[i] 代表如果选数字 i，从 0 处理到 i 的最大和
 * <li>nonSelect[i] 代表如果不选数字 i，从 0 处理到 i 的最大和
 * </ul>
 * 那么我们有以下逻辑：
 * <ul>
 * <li>如果选 i，那么 i-1 肯定不能选；
 * <li>如果不选 i，那么 i-1 选不选都可以，因此我们选择其中较大的选法
 * </ul>
 * {@code select[i] = nonSelect[i-1] + sums[i];}
 * <p>
 * {@code nonSelect[i] = Math.max(select[i-1], nonSelect[i-1]);}
 * 
 * @author sichu
 * @date 2021/09/07
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // if (nums.length == 0) {
        // return 0;
        // }
        //
        // int[] sums = new int[20000];
        // int[] select = new int[20000];
        // int[] nonSelect = new int[20000];
        //
        // int maxV = 0;
        // for (int num : nums) {
        // sums[num] += num;
        // maxV = Math.max(maxV, num);
        // }
        //
        // for (int i = 1; i <= maxV; i++) {
        // select[i] = nonSelect[i - 1] + sums[i];
        // nonSelect[i] = Math.max(select[i - 1], nonSelect[i - 1]);
        // }
        // return Math.max(select[maxV], nonSelect[maxV]);
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
        int len = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
