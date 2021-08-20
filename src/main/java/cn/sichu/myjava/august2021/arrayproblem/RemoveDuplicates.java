package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 26. 删除有序数组中的重复项 @see<a href = "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array">删除有序数组中的重复项</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个有序数组 nums ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95"> 原地
 * </a></strong>删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。<br>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * @author sichu
 * @date 2021/08/18
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return len - cnt;
    }
}
