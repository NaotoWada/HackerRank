package main.yurufuwa.onsite2;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class E_UsagiVSKame {

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

        rec(ai, bi);

        for (int i = 0; i < Q; i++) {
            long kame = q[i];
            long usagi = Usagi.getCurrent(q[i]);
            System.out.printf("kame%s\nusgi%s\n", kame, usagi);
            if (kame == usagi) {
                System.out.println("draw");
            } else if (kame > usagi) {
                System.out.println("kame");
            } else {
                System.out.println("usagi");
            }
        }
    }

    private static void rec(int[] ai, int[] bi) {
        long tmpA = 0;
        long tmpB = 0;
        for (int i = 0; i < ai.length; i++) {
            tmpA += ai[i];
            tmpB += bi[i];
            Usagi.add(tmpA, tmpB);
        }
    }

    static class Usagi {
        static Map<Long, Long> record = new TreeMap<>(Collections.reverseOrder());

        public static long getCurrent(long proc) {
            for (Entry<Long, Long> ent : record.entrySet()) {
                if (ent.getKey() <= proc) {
                    return ent.getValue();
                }
            }
            return 0;
        }

        public static void add(long tmpA, long tmpB) {
            record.put(tmpA, tmpB);
        }
    }
}
