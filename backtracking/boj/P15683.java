package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15683 {
    static List<Point> points = new ArrayList<>();
    static int res = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] office = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)  {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 0 && office[i][j] != 6) {
                    points.add(new Point(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);
        System.out.println(res);

        br.close();
    }

    static void dfs(int idx, int[][] arr) {
        if (idx == points.size()) {
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        count++;
                    }
                }
            }

            res = Math.min(res, count);
            return;
        }

        Point p = points.get(idx);
        switch (p.val) {
            case 1:
                int[][] tmp1 = cloneArray(arr);
                dfs(idx + 1, fillUp(p.x, p.y, tmp1));

                int[][] tmp2 = cloneArray(arr);
                dfs(idx + 1, fillDown(p.x, p.y, tmp2));

                int[][] tmp3 = cloneArray(arr);
                dfs(idx + 1, fillLeft(p.x, p.y, tmp3));

                int[][] tmp4 = cloneArray(arr);
                dfs(idx + 1, fillRight(p.x, p.y, tmp4));
                break;
            case 2:
                int[][] tmp5 = cloneArray(arr);
                fillLeft(p.x, p.y, tmp5);
                fillRight(p.x, p.y, tmp5);
                dfs(idx + 1, tmp5);

                int[][] tmp6 = cloneArray(arr);
                fillUp(p.x, p.y, tmp6);
                fillDown(p.x, p.y, tmp6);
                dfs(idx + 1, tmp6);
                break;
            case 3:
                int[][] tmp7 = cloneArray(arr);
                fillUp(p.x, p.y, tmp7);
                fillLeft(p.x, p.y, tmp7);
                dfs(idx + 1, tmp7);

                int[][] tmp8 = cloneArray(arr);
                fillUp(p.x, p.y, tmp8);
                fillRight(p.x, p.y, tmp8);
                dfs(idx + 1, tmp8);

                int[][] tmp9 = cloneArray(arr);
                fillDown(p.x, p.y, tmp9);
                fillLeft(p.x, p.y, tmp9);
                dfs(idx + 1, tmp9);

                int[][] tmp10 = cloneArray(arr);
                fillDown(p.x, p.y, tmp10);
                fillRight(p.x, p.y, tmp10);
                dfs(idx + 1, tmp10);
                break;
            case 4:
                int[][] tmp11 = cloneArray(arr);
                fillUp(p.x, p.y, tmp11);
                fillLeft(p.x, p.y, tmp11);
                fillRight(p.x, p.y, tmp11);
                dfs(idx + 1, tmp11);

                int[][] tmp12 = cloneArray(arr);
                fillDown(p.x, p.y, tmp12);
                fillLeft(p.x, p.y, tmp12);
                fillRight(p.x, p.y, tmp12);
                dfs(idx + 1, tmp12);

                int[][] tmp13 = cloneArray(arr);
                fillUp(p.x, p.y, tmp13);
                fillDown(p.x, p.y, tmp13);
                fillRight(p.x, p.y, tmp13);
                dfs(idx + 1, tmp13);

                int[][] tmp14 = cloneArray(arr);
                fillUp(p.x, p.y, tmp14);
                fillDown(p.x, p.y, tmp14);
                fillLeft(p.x, p.y, tmp14);
                dfs(idx + 1, tmp14);
                break;
            case 5:
                int[][] tmp15 = cloneArray(arr);
                fillUp(p.x, p.y, tmp15);
                fillDown(p.x, p.y, tmp15);
                fillLeft(p.x, p.y, tmp15);
                fillRight(p.x, p.y, tmp15);
                dfs(idx + 1, tmp15);
                break;
        }
    }

    static int[][] cloneArray(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                copy[i][j] = original[i][j];
            }
        }

        return copy;
    }

    static int[][] fillUp(int x, int y, int[][] arr) {
        for (int i = x - 1; i >= 0; i--) {
            if (arr[i][y] == 6) {
                return arr;
            }
            arr[i][y] = -1;
        }
        
        return arr;
    }

    static int[][] fillDown(int x, int y, int[][] arr) {
        for (int i = x + 1; i < arr.length; i++) {
            if (arr[i][y] == 6) {
                return arr;
            }
            arr[i][y] = -1;
        }
        
        return arr;
    }

    static int[][] fillLeft(int x, int y, int[][] arr) {
        for (int i = y - 1; i >= 0; i--) {
            if (arr[x][i] == 6) {
                return arr;
            }
            arr[x][i] = -1;
        }
        
        return arr;
    }

    static int[][] fillRight(int x, int y, int[][] arr) {
        for (int i = y + 1; i < arr[0].length; i++) {
            if (arr[x][i] == 6) {
                return arr;
            }
            arr[x][i] = -1;
        }
        
        return arr;
    }


    /**
     * InnerP15683
     */
    static class Point {
        int x, y;
        int val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
