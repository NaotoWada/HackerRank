package main.yurufuwa.onsite2;

import java.time.LocalDateTime;

public class Outpt {

    public static void main(String[] args) {
        LocalDateTime s = LocalDateTime.now();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 99999; i++) {
            sb.append("kame");
            sb.append("\n");
        }
        System.out.println(sb.toString());
        LocalDateTime a = LocalDateTime.now();
        System.out.println(s);
        System.out.println(a);
    }
}
