package cn.sichu.myjava.august2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号 @see<a href = "https://leetcode-cn.com/problems/valid-parentheses/">20. 有效的括号</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 * <p>
 * 有效字符串需满足：
 * <ol>
 * <li>左括号必须用相同类型的右括号闭合。
 * <li>左括号必须以正确的顺序闭合。
 * </ol>
 * <strong>解法</strong>
 * <p>
 * 栈实现。 因为先出现的左括号后匹配，可以模式识别： 先进后出用(后进先出)栈
 * <p>
 * 遍历括号字符串，遇到左括号时，将左括号压入栈中；遇到右括号时，弹出栈顶元素（栈若为空，直接返回 false），判断是否是相同类型的括号。若不匹配，直接返回 false。
 * <p>
 * 遍历结束，栈若为空，说明括号字符串有效。
 * 
 * @author sichu
 * @date 2021/08/29
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (char ch : chars) {
            boolean left = ch == '(' || ch == '[' || ch == '{';
            if (left) {
                q.push(ch);
            } else if (q.isEmpty() || !match(q.pop(), ch)) {
                return false;
            }
        }
        return q.isEmpty();
    }

    private boolean match(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }
}
