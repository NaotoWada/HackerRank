package main.yurufuwa.onsite2;

import java.util.Scanner;

public class A_HondasJanken {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String honda = sc.nextLine();

        char a = honda.charAt(0);
        char b = honda.charAt(1);
        System.out.println(a == b ? "draw" : "honda");
    }
}
