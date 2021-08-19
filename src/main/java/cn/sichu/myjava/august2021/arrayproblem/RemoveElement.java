package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 移除元素 @see<a href = "https://leetcode-cn.com/problems/remove-element">移除元素</a>
 * <p>
 * <strong>题目描述:<strong>
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95"> 原地
 * </a></strong>移除所有数值等于 val 的元素，并返回移除后数组的新长度。<br>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。<br>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return len - cnt;
    }
}
