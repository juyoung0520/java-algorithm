package backtracking.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {
    static private int n, m;
    static private List<Point> home, chicken;
    static private boolean[] visited;
    static private int ans = Integer.MAX_VALUE;

    static private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 2) {
                    chicken.add(new Point(i, j));
                } else if (value == 1) {
                    home.add(new Point(i, j));
                }
            }
        }
        br.close();
        visited = new boolean[chicken.size()];

        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int idx, int start) {
        if (idx == m) {
            int tmp = 0;

            for (Point h : home) {
                int dis = Integer.MAX_VALUE;

                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        Point c = chicken.get(i);
                        dis = Math.min(dis, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
                    }
                }

                tmp += dis;
            }

            ans = Math.min(ans, tmp);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(idx + 1, i + 1);
            visited[i] = false;
        }
    }
}
