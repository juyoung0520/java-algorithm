package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9466 {
    static int tc, n, teamMember;
    static int[] graph;
    static boolean[] visited;
    static boolean[] done;
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
            done = new boolean[n+1];
            teamMember = 0;

            // 어차피 사이클로 끝난다. 연결 요소 비슷
            for (int k = 1; k <= n; k++) {
                // visited면 done이다. (visited인데 done아닌 것 탐색 중 나타남)
                if (!done[k]) {
                    dfs(k);
                }
            }

            System.out.println(n - teamMember);
        }
    }

    static void dfs(int k) {
        visited[k] = true;
        int next = graph[k];

        if (!visited[next]) {
            dfs(next);
        } else {
            // 이번 탐색 때 처음 방문한 사이클일 때 (사이클 아닌 방문한 노드 혹은 방문한 사이클 제외 조건)
            if (!done[next]) {
                teamMember++;
                while (next != k) {
                    teamMember++;
                    next = graph[next];
                }
            }
        }

        // 이번 탐색 모든 노드 done 이고 visited
        done[k] = true;
    }
    
}
