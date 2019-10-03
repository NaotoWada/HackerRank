package main.yurufuwa.onsite2;

import java.util.Scanner;

public class E_UsagiVSKame4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = Integer.parseInt(sc.next());
        int[] ai = new int[S];
        for (int i = 0; i < S; i++) {
            ai[i] = Integer.parseInt(sc.next());
        }
        int[] bi = new int[S];
        for (int i = 0; i < S; i++) {
            bi[i] = Integer.parseInt(sc.next());
        }

        int Q = Integer.parseInt(sc.next());
        long[] q = new long[Q];
        for (int i = 0; i < Q; i++) {
            q[i] = Long.parseLong(sc.next());
        }

        long[][] uq = new long[S][2];
        long time = 0;
        long dist = 0;
        for (int i = 0; i < S; i++) {
            time += ai[i];
            dist += bi[i];
            uq[i][0] = time;
            uq[i][1] = dist;
        }

        int up = 0;
        long usagiPoint = 0;
        for (int i = 0; i < Q; i++) {
            long kameSec = q[i];
            for (; up < S; up++) {
                long us1 = uq[up][0];
                if (kameSec < us1) {
                    break;
                }

                usagiPoint = uq[up][1];
            }
            solve(kameSec, usagiPoint);
        }
    }

    private static void solve(long kame, long usagi) {
        if (kame == usagi) {
            System.out.println("draw");
        } else if (kame > usagi) {
            System.out.println("kame");
        } else {
            System.out.println("usagi");
        }
    }
}
