package main.yurufuwa.onsite2;

import java.util.Scanner;

public class B_Sentouryoku {

    public static void main(String[] args) {
        System.out.println("Z".codePointAt(0));
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int[] codePoint = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            codePoint[i] = S.codePointAt(i) - 64;
        }

        int[] sum = new int[codePoint.length - 1];
        for (int i = 0; i < codePoint.length - 1; i++) {
            sum[i] = codePoint[i] + codePoint[i + 1];
        }

        long ans = sum[0];
        for (int i = 1; i < sum.length; i++) {
            ans *= sum[i];
        }
        System.out.println(ans);
    }
}
