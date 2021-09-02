package cn.sichu.myjava.september2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. 基本计算器 II @see<a href = "https://leetcode-cn.com/problems/basic-calculator-ii/">227. 基本计算器 II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。 <strong>解法</strong>
 * <p>
 * 遍历字符串 s，并用变量 preSign 记录每个数字之前的运算符，对于第一个数字，其之前的运算符视为加号。每次遍历到数字末尾时，根据 preSign 来决定计算方式：
 * <ul>
 * <li>加号：将数字压入栈；
 * <li>减号：将数字的相反数压入栈；
 * <li>乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
 * </ul>
 * 
 * @author sichu
 * @date 2021/09/02
 */
public class Calculate {
    public int calculate(String s) {
        int num = 0;
        char presign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, n = s.length(); i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (i == n - 1 || (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')) {
                switch (presign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                presign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
