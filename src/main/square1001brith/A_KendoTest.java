package main.square1001brith;

import static org.junit.Assert.*;
import org.junit.Test;
import main.square1001brith.A_Kendo2.Player;

public class A_KendoTest {

    @Test
    public void test() {
        Player[] p = make(10010);
        long actual = A_Kendo2.solve(p);
        assertEquals(167117070120L, actual);
    }

    private Player[] make(int i) {
        Player[] p = new Player[i];
        for (int j = 0; j < i; j++) {
            String param = String.valueOf(j + 1);
            String[] s = { param, param, param };
            p[j] = new Player(s);
        }
        return p;
    }
}
