package main.square1001brith;

import java.util.Scanner;

public class A_Kendo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        long ans = solve(n, a, b, c);
        System.out.println(ans);
    }

    private static long solve(int n, int[] a, int[] b, int[] c) {

        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            long senpou = 0;
            long taisho = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j] && b[i] < b[j] && c[i] < c[j]) {
                    senpou++;
                }
                if (a[j] < a[i] && b[j] < b[i] && c[j] < c[i]) {
                    taisho++;
                }
            }
            ans += senpou * taisho;
        }
        return ans;
    }
}
