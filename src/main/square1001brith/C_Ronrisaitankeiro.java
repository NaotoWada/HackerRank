package main.square1001brith;

import java.util.Scanner;

public class C_Ronrisaitankeiro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        long[][] grid = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = sc.nextLong();
            }
        }

        int ans = solve(w, h, grid);
    }

    private static int solve(int w, int h, long[][] grid) {
        long ans = 0;
        dfs(0, 0, w, h, grid);
        return 0;
    }

    static void dfs(int x, int y, int W, int H, long[][] grid) {
        if (x >= W || y >= H) {
            return;
        }
        if (grid[y][x] == -1)
            return;

        // 経路をメモれなくてDFSは無理っぽい

        dfs(x + 1, y, W, H, grid);
        dfs(x, y + 1, W, H, grid);
    }
}
