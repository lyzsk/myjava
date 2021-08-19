package cn.sichu.myjava.august2021.javacorelearning;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class JavaBeanLearning {
    private String name;
    private int age;

    public JavaBeanLearning(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(JavaBeanLearning.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("    " + pd.getReadMethod());
            System.out.println("    " + pd.getWriteMethod());
        }
    }
}
