package main.square1001brith;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class B_Performance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
            set.add(a[i]);
        }

        if (set.size() == 1) {
            System.out.println(a[0]);
            return;
        }

        int bef = 0;
        int max = -99999;
        for (int tmp = -5005; tmp < 5005; tmp++) {
            Queue<Integer> inner = new PriorityQueue<>(Comparator.naturalOrder());
            bef = tmp;
            inner.add(bef);
            for (int j = 0; j < a.length; j++) {
                int doublePoint = a[j] * 2;
                int middle = doublePoint - bef;
                bef = middle;
                inner.add(bef);
            }
            max = Math.max(max, inner.poll());
        }

        System.out.println(max);
    }
}
