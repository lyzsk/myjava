package cn.sichu.myjava.september2021.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 解法
 * <p>
 * 先设置每一行首尾元素为 1，其它元素为 0。然后根据杨辉三角，设置每一行其它元素即可。
 * 
 * @author sichu
 * @date 2021/09/27
 */
public class Generate {
    // public List<List<Integer>> generate(int numRows) {
    // List<List<Integer>> res = new ArrayList();
    // for (int i = 0; i < numRows; i++) {
    // List<Integer> t = new ArrayList<Integer>();
    // for (int j = 0; j < i + 1; j++) {
    // boolean firstOrLast = j == 0 || j == i;
    // t.add(firstOrLast ? 1 : 0);
    // }
    // for (int j = 1; j < i; j++) {
    // int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
    // t.set(j, val);
    // }
    // res.add(t);
    // }
    // return res;
    // }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
