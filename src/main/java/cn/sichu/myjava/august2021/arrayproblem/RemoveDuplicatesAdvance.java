package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 删除有序数组中的重复项
 * II @see<a href = "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii">删除有序数组中的重复项II</a>
 * </p>
 * <strong>题目描述:</strong>
 * <p>
 * 给你一个有序数组 nums ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95"> 原地
 * </a></strong>删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <strong>解法:</strong>
 * <p>
 * 从数组下标 1 开始遍历数组<br>
 * 用计数器 cnt 记录当前数字重复出现的次数，cnt 的最小计数为 0；用 cur 记录新数组下个待覆盖的元素位置。<br>
 * 遍历时，若当前元素 nums[i] 与上个元素 nums[i-1] 相同，则计数器 +1， 否则计数器重置为 0。如果计数器小于 2，说明当前元素 nums[i] 可以添加到新数组中，即：nums[cur] = nums[i]，同时
 * cur++。<br>
 * 遍历结果，返回 cur 值即可。
 * 
 * @author sichu
 * @date 2021/08/18
 */
public class RemoveDuplicatesAdvance {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ++cnt;
            } else {
                cnt = 0;
            }
            if (cnt < 2) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
