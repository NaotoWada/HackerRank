package main.yurufuwa.onsite2;

import java.util.Scanner;

public class E_UsagiVSKame2 {

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

        Usagi.rec(ai, bi);

        for (int i = 0; i < Q; i++) {
            long kame = q[i];
            long usagi = Usagi.getCurrent(q[i]);
            if (kame == usagi) {
                System.out.println("draw");
            } else if (kame > usagi) {
                System.out.println("kame");
            } else {
                System.out.println("usagi");
            }
        }
    }

    static class Usagi {
        static long[][] SEC_POINT;
        static int LAST = 0;
        static long NEXT_SEC = 0;

        public static long getCurrent(long proc) {
            if (proc >= NEXT_SEC && LAST + 1 < SEC_POINT.length) {
                long ret = SEC_POINT[LAST + 1][1];
                NEXT_SEC = SEC_POINT[LAST + 1][0];
                LAST++;
                return ret;
            }

            return SEC_POINT[LAST][1];
        }

        public static void rec(int[] ai, int[] bi) {
            SEC_POINT = new long[ai.length + 1][2];
            long tmpA = 0;
            long tmpB = 0;
            for (int i = 0; i < ai.length; i++) {
                tmpA += ai[i];
                tmpB += bi[i];
                SEC_POINT[i + 1][0] = tmpA;
                SEC_POINT[i + 1][1] = tmpB;
            }

            NEXT_SEC = SEC_POINT[1][0];
        }
    }
}
