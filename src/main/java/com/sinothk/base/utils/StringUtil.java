package com.sinothk.base.utils;

public class StringUtil {

    public static boolean isEmpty(String value) {

        if (value == null) {
            return true;
        }

        value = value.trim();

        return value.length() == 0 || value.equals("null")
                || value.equals("NULL")
                || value.equals("Null");
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * 长度是否在a到b之间
     *
     * @param value
     * @param a
     * @param b
     * @return
     */
    public static boolean isBetweenAtoB(String value, int a, int b) {
        if (isEmpty(value)) {
            return false;
        }

        if (value.length() >= a && value.length() <= b) {
            return true;
        }

        return false;
    }

    /**
     * 获得星号代替的字符串。形如：12345 =>getStarString("12345", 1, 3)=> 1***5。星数和字符串个数相同情况
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String getStarString(String str, int start, int end) {
        try {
            String startStr = str.substring(0, start);
            String endStr = str.substring(end, str.length());

            String starStr = "";
            for (int i = start; i < end; i++) {
                starStr = starStr + "*";
            }

            return startStr + starStr + endStr;
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 获得星号代替的字符串。星号个数根据长度替换
     *
     * @param paramString
     * @return
     */
    public static String getStarString(String paramString) {
        try {
            if (paramString == null || paramString.equals("")) {
                return "";
            }

            int i = paramString.length();
            if (i <= 6) {
                return paramString;
            }

            if ((i <= 15) && (i > 6)) {
                String str5 = paramString.substring(0, 3);
                String str6 = paramString.substring(6);
                return str5 + "***" + str6;
            }

            if ((i <= 18) && (i > 15)) {
                String str1 = paramString.substring(0, 8);
                String str2 = paramString.substring(12);
                return str1 + "****" + str2;
            }

            if (i > 18) {
                String str3 = paramString.substring(0, 10);
                String str4 = paramString.substring(14);
                return str3 + "****" + str4;
            }
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 判断字符串是否是电子邮箱地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null || "".equals(email)) return false;
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }
}
