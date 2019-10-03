package main.yurufuwa.onsite2;

import java.util.Scanner;

public class F_MnemeGame {

    static String ABC = "ABC";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        String S = sc.next();
        int Q = Integer.parseInt(sc.next());
        long[] q = new long[Q];
        for (int i = 0; i < Q; i++) {
            q[i] = Long.parseLong(sc.next());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + 1; i++) {
            add(sb, i);
        }

        String memory = sb.toString();
        for (int i = 0; i < Q; i++) {
            long query = q[i];
            System.out.println(memory.charAt((int) query - 1));
        }

    }

    private static void add(StringBuilder sb, int i) {
        if (i > 3) {
            for (int j = 0; j < 3; j++) {
                sb.append(ABC.charAt(j));
            }
            add(sb, i - 3);
        } else {
            for (int j = 0; j < i; j++) {
                j = j % 3;
                sb.append(ABC.charAt(j));
            }
        }
    }
}
