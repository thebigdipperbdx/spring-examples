package org.spring.mvc.utils;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-07-25 8:29
 */
public class MethodTest {
    private int add4(int x1, int x2, int x3, int x4) {
        return add2(x1, x2) + add2(x3, x4);
    }

    private int add2(int x1, int x2) {
        return x1 + x2;
    }

    public static void main(String[] args){
        MethodTest methodTest=new MethodTest();
        int sum=methodTest.add4(1,2,3,3);
        System.out.println(sum);
        int  temp=10;
        System.out.println(temp);
    }
}
