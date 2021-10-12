package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P11724 {
    static int n, m;
    static int[][] graph;
    static boolean[]  visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[n+1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                bfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }

    static void dfs(int node) {
        if (visited[node] == true) {
            return;
        }

        visited[node] = true;

        for (int i = 1; i <=n; i++) {
            if (graph[node][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }

    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int node = que.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && visited[i] == false ) {
                    que.offer(i);
                    visited[i] = true;
                }
            } 

        }
    }
}