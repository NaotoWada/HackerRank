package main.square1001brith;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A_Kendo2 {

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

        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                Player p1 = a[i];
                Player p2 = a[j];
                if (p1.atk >= p2.atk || p1.def >= p2.def || p1.luk >= p2.luk) {
                    continue;
                }
                for (int j2 = j + 1; j2 < a.length; j2++) {
                    Player p3 = a[j2];
                    if (p2.atk >= p3.atk || p2.def >= p3.def || p2.luk >= p3.luk) {
                        continue;
                    } else {
                        ans++;
                    }
                }
            }
        }

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
