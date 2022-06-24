package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2589 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited;

    static class Point {
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[n][m];
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int i, int j) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(i, j, 0));
        visited[i][j] = true;

        int cnt = 0;
        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int k = 0; k < 4; k++) {
                int i1 = p.x + dx[k];
                int j1 = p.y + dy[k];

                if (i1 >= 0 && i1 < arr.length && j1 >= 0 && j1 < arr[0].length && arr[i1][j1] == 'L' && !visited[i1][j1]) {
                    visited[i1][j1] = true;
                    que.add(new Point(i1, j1, p.cnt + 1));
                    cnt = Math.max(cnt, p.cnt + 1);
                }
            }
        }

        return cnt;
    }
}
