package main.yurufuwa.onsite2;

import java.util.Scanner;

public class D_n_dwitchBox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        // must replace #| first.
        String rep = S.replace("#|", "z").replace("|", "1");
        System.err.println(rep);

        int i = 0;
        for (; i < rep.length(); i++) {
            if (i + 1 < rep.length() && rep.charAt(i + 1) == 'z') {
                // Sequence 'z' char means add to n-dwitch.
                int zCount = 0;
                for (int j = i + 1; j < rep.length(); j++) {
                    if (rep.charAt(j) != 'z') {
                        break;
                    }
                    zCount++;
                }
                int sum = Integer.parseInt(String.valueOf(rep.charAt(i))) + zCount;
                System.out.print(sum + " ");

                // Skip to after 'z' char.
                i += zCount;
            } else {
                // char | only.
                System.out.print(rep.charAt(i) + " ");
            }
        }
    }
}
