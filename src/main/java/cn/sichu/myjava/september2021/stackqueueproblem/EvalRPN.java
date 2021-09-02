package cn.sichu.myjava.september2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <strong>150.
 * 逆波兰表达式求值</strong> @see<a href = "https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">150.
 * 逆波兰表达式求值</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 根据 <a href = "https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437">逆波兰表示法</a>，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <ul>
 * <li>整数除法只保留整数部分。
 * <li>给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * </ul>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <ul>
 * <li>平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * <li>该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * </ul>
 * 逆波兰表达式主要有以下两个优点：
 * <ul>
 * <li>去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * <li>适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 * </ul>
 * 解法
 * <p>
 * 栈实现。
 * <p>
 * 遍历数组，遇到数字则压入栈中，遇到运算符号，则从栈中弹出右、左操作数，运算过后，将结果压入栈中。
 * <p>
 * 遍历结束后，返回栈中的唯一元素。
 * 
 * 
 * @author sichu
 * @date 2021/09/01
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        int left, right;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    right = s.pop();
                    left = s.pop();
                    s.push(left + right);
                    break;
                case "-":
                    right = s.pop();
                    left = s.pop();
                    s.push(left - right);
                    break;
                case "*":
                    right = s.pop();
                    left = s.pop();
                    s.push(left * right);
                    break;
                case "/":
                    right = s.pop();
                    left = s.pop();
                    s.push(left / right);
                    break;
                default:
                    s.push(Integer.valueOf(token));
            }
        }
        return s.pop();
    }

}
