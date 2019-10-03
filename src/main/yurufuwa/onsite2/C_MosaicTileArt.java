package main.yurufuwa.onsite2;

import java.util.Scanner;

public class C_MosaicTileArt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = Integer.parseInt(sc.nextLine());
        long[] ans = new long[S + 2];

        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= S; i++) {
            long tmp = ans[i - 1] * i % 1000000007;
            ans[i] = tmp;
        }

        System.out.println(ans[S]);
    }
}
