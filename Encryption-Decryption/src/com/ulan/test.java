package com.ulan;

import java.util.Scanner;

public class test {
    static String str;

    static String printParameter(String s) {
        if (s.substring(s.indexOf("=")).length() < 2)
            str = s.replace("=", " : not found");
        else str = s.replace("=", " : ");
        return str;
    }

    public static void main(String[] args) {
        System.out.println(Calculator1.class.getName());
        Scanner sc = new Scanner(System.in);

        String url = sc.nextLine();
        String pStr = "";
        url = url.substring(url.indexOf("?") + 1);
        String[] arrUrl = url.split("&");

        for (String s : arrUrl) {
            if (s.contains("pass")) pStr = s;
            System.out.println(printParameter(s));
        }
        if (pStr.length() > 1)
            System.out.println(printParameter(pStr).replace("pass", "password"));

//        int n = sc.nextInt();
        /*String[] subs = str1.split(str2);
        System.out.println(Arrays.toString(subs));*/
        /*if (str1.length() >= n) {
            System.out.println(str1.substring(n) + str1.substring(0, n));
        } else System.out.println(str1);*/

/*
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch != str2.charAt(str2.length() - 1)) {
                str2 += ch;
            }
        }
        System.out.println(str2);
*/
    }
}
