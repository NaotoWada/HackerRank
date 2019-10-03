package main.square1001brith;

import java.util.Scanner;

public class B_Performance2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
        }

        int[] d = new int[n];
        d[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            d[i + 1] = a[i] * 2 - d[i];
        }

        int t = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s = Math.min(s, d[i]);
            } else {
                t = Math.min(t, d[i]);
            }
        }

        System.out.println((t + s) / 2);
    }
}
