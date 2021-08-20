package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 169. 多数元素 @see<a href = "https://leetcode-cn.com/problems/majority-element">多数元素</a>
 * <p>
 * <strong>题目描述:</strong>
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 进阶：
 * <ul>
 * <li>尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * </ul>
 * <strong>解法</strong>
 * <p>
 * 摩尔投票法。时间复杂度 O(n)，空间复杂度 O(1)。
 * 
 * @author sichu
 * @date 2021/08/18
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int major = 0;

        for (int num : nums) {
            if (cnt == 0) {
                major = num;
                cnt = 1;
            } else {
                cnt += (major == num ? 1 : -1);
            }
        }
        return major;
    }
}
