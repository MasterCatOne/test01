package com.example.utils;

import java.util.Random;

public class RandomUtils {
    /**
     * 获取随机长度的字符串串
     *
     * @param length
     * @return
     */
    private static final String ALL_CHAR_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 获取随机数
     * @param length 字符串长度
     * @return 指定长度的随机字符串
     */
    public static String getRandomString(int length) {
        //生成随机数字和字母
        Random random = new Random();
        StringBuilder saltString = new StringBuilder(length);
        for (int i = 1; i <= length; ++i) {
            saltString.append(ALL_CHAR_NUM.charAt(random.nextInt(ALL_CHAR_NUM.length())));
        }
        return saltString.toString();
    }
}