package main.yurufuwa.onsite2;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class E_UsagiVSKame3 {

    static String KAME = "kame";
    static String USAGI = "usagi";
    static String DRAW = "draw";

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
            // System.out.printf("kame%s\nusgi%s\n", kame, usagi);
            if (kame == usagi) {
                System.out.println(DRAW);
            } else if (kame > usagi) {
                System.out.println(KAME);
            } else {
                System.out.println(USAGI);
            }
            // System.out.println();
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
        Usagi.reset();
    }

    static class Usagi {
        static Map<Long, Long> record = new TreeMap<>(Collections.reverseOrder());
        static long[] record_point;
        static int latest;

        public static long getCurrent(long proc) {
            long usagi = record.get(record_point[latest]);
            if (usagi <= proc) {
                proceed(proc);
            }

            if (latest == 0) {
                if (usagi == proc) {
                    return record.get(record_point[latest]);
                }
                return 0;
            } else {
                return record.get(record_point[latest]);
            }
        }

        private static void proceed(long proc) {
            for (; latest < record_point.length - 1; latest++) {
                long usagi = record_point[latest];
                long next = record_point[latest + 1];
                if (usagi <= proc && proc < next) {
                    break;
                }
                // System.out.printf("%s < %s < %s \n", usagi, proc, next);
            }
        }

        public static void add(long tmpA, long tmpB) {
            record.put(tmpA, tmpB);
        }

        public static void reset() {
            int lim = record.size();
            record_point = new long[lim];
            int i = 0;
            for (Entry<Long, Long> ent : record.entrySet()) {
                record_point[lim - i - 1] = ent.getKey();
                i++;
            }
            latest = 0;
        }
    }
}
