package cn.sichu.myjava.august_2021.linkedlistproblem;

/**
 * 题目描述:<ul>
 * 给你一个有序数组 <b>nums</b> ，请你 @see <strong><a href = "http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%
 * E7%AE%97%E6%B3%95">原地 </a></strong> 删除重复出现的元素，
 * 使每个元素 只出现一次 ，返回删除后数组的新长度。<br>
 * 不要使用额外的数组空间，你必须在 原地 
 * 修改输入数组 并在使用 O(1) 额外空间的条件下完成。</ul>
 * <p>说明:
 * <p>为什么返回数值是整数，但输出的答案是数组呢?
 * <p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，
 * 这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>你可以想象内部操作如下:</p><pre>
 * // <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
 * for (int i = 0; i < len; i++) {
 * 	print(nums[i]);
 * }</pre>
 * <p>
 * 示例 1：<ul>
 * 输入： nums = [1,1,2]<p>
 * 输出：2, nums = [1,2]<p>
 * 解释：函数应该返回新的长度 2 ，
 * 并且原数组 <em>nums</em> 的前两个元素被修改为 1, 2 。
 * 不需要考虑数组中超出新长度后面的元素。</ul>
 * <p>
 * 示例 2：<ul>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]<p>
 * 输出：5, nums = [0,1,2,3,4]<p>
 * 解释：函数应该返回新的长度 5 ，并且原数组 <em>nums</em> 的前五个元素被修改为
 *  0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。</ul>
 * <p>
 * 提示：<ul>
 * 0 <= nums.length <= 3 * 10 <sup>4</sup><p>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup><p>
 * nums 已按升序排列</ul>
 * 
 * @author sichu
 *
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		int count = 0, len = nums.length;
		
		for (int i = 1; i < len; i++) {
			if (nums[i] == nums[i - 1]) ++count;
			else nums[i - count] = nums[i];
		}
		return len - count;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {1, 2, 3, 3, 5, 7, 9, 1};
		System.out.println("Result: " + new RemoveDuplicates().removeDuplicates(nums) + 1);
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}
}
