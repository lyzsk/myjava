package cn.sichu.myjava.august2021.javacorelearning;

import java.util.StringJoiner;

/**
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class StringJoinerLearning {
    private static String[] names = {"hsc", "xxx", "alice"};

    public void useStringBuilder(StringBuilder sb) {
        sb.append("hello ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("!");
        System.out.println(sb.toString());
    }

    public void useStringJoiner(StringJoiner sj) {
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }

    public String buildSelectSql(String table, String[] fields) {
        var sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        StringJoinerLearning sjl = new StringJoinerLearning();
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(", ");
        sjl.useStringBuilder(sb);
        sjl.useStringJoiner(sj);
        StringJoiner sj2 = new StringJoiner(", ", "hello ", "!");
        sjl.useStringJoiner(sj2);
        // String.join()
        String s = String.join(", ", names);
        System.out.println(s);

        // use StringJoiner to construct a SELECT statement
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = sjl.buildSelectSql(table, fields);
        System.out.println(select);
        System.out
            .println("SELECT name, position, salary FROM employee".equals(select) ? "test success" : "test failed");
    }
}
