package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 283. 移动零 @see<a href = "https://leetcode-cn.com/problems/move-zeroes">移动零</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * <strong>说明:</strong>
 * <ol>
 * <li>必须在原数组上操作，不能拷贝额外的数组。
 * <p>
 * <li>尽量减少操作次数。
 * </ol>
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 1) {
            return;
        }
        int zeroCnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                ++zeroCnt;
            } else {
                nums[i - zeroCnt] = nums[i];
            }
        }
        while (zeroCnt > 0) {
            nums[len - zeroCnt--] = 0;
        }
    }
}
