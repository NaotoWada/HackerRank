package main.square1001brith;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A_Kendo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Player[] a = new Player[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Player(sc.nextLine().split(" "));
        }
        long ans = solve(a);
        System.out.println(ans);
    }

    static long solve(Player[] a) {
        Arrays.sort(a, Comparator.naturalOrder());
        Player bp = a[0];
        for (int i = 1; i < a.length; i++) {
            Player np = a[i];
            if (bp.atk >= np.atk || bp.def >= np.def || bp.luk >= np.luk) {
                a[i] = null;
            } else {
                bp = np;
            }
        }

        long count = Arrays.stream(a).filter(s -> s != null).count();
        long ans = calc(count);
        return ans;
    }

    private static long calc(long count) {

        if (count < 3) {
            return 0;
        }
        if (count == 3) {
            return 1;
        }

        long bunshi = 1;
        for (long i = 1; i <= 3; i++) {
            bunshi *= count;
            count--;
        }

        long ans = bunshi / 6;
        return ans;
    }

    static class Player implements Comparable<Player> {
        long atk;
        long def;
        long luk;

        Player(String[] param) {
            this.atk = Long.parseLong(param[0]);
            this.def = Long.parseLong(param[1]);
            this.luk = Long.parseLong(param[2]);
        }

        @Override
        public int compareTo(Player o) {
            if (this.atk - o.atk == 0) {
                if (this.def - o.def == 0) {
                    return (int) (this.luk - o.luk);
                }
                return (int) (this.def - o.def);
            }
            return (int) (this.atk - o.atk);
        }

        @Override
        public String toString() {
            return String.format("%s %s %s", atk, def, luk);
        }
    }
}
