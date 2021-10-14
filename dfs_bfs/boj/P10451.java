package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10451 {
    static int tc, n;
    static int[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            
            graph = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n+1];
            int count = 0;

            // 어차피 사이클로 끝난다. 연결 요소 비슷
            for (int k = 1; k <= n; k++) {
                if (visited[k] == false) {
                    bfs(k);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int k) {
        visited[k] = true;

        if (!visited[graph[k]]) {
            dfs(graph[k]);
        }
    }

    static void bfs(int k) {
        Queue<Integer> que = new LinkedList<>();
        visited[k] = true;
        que.offer(k);
        
        while (!que.isEmpty()) {
            int node = que.poll();

            if (!visited[graph[node]]) {
                que.offer(graph[node]);
                visited[graph[node]] = true;
            }
        }
    }
    
}
