package com.restep.exception;

/**
 * @author shifeng@worken.cn
 * @date 2020/2/11
 */
public class TryCatchTest {
    public static void main(String[] args) {
        try {
            System.out.println("第1层逻辑");

            try {
                int a = 1;
                int b = 0;
                int c = a / b;
            } catch (Exception e) {
                System.out.println("第2层异常");
            }
        } catch (Exception e) {
            System.out.println("第1层异常");
        }

        System.out.println("最后的逻辑");
    }
}