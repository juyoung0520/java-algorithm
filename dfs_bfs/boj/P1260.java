package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    static int n, m, v;
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[n+1];

        DFS(v);
        System.out.println();

        Arrays.fill(visited, false);

        BFS(v);
        System.out.println();
    }

    static void DFS(int node) {
        if (visited[node]) {
            return;
        }
        
        visited[node] = true;
        System.out.print(node+" ");

        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && visited[i] == false) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int node = que.poll();
            System.out.print(node+" ");

            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && visited[i] == false) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
    
}
