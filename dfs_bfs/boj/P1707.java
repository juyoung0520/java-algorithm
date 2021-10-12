package dfs_bfs.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1707 {
    static int k, v, e;
    // 메모리 초과. ArrayList로 바꿔야될듯..
    static int[][] graph;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            v = sc.nextInt();
            e = sc.nextInt();
            graph = new int[v+1][v+1];

            for (int j = 1; j <= e; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x][y] = 1;
                graph[y][x] = 1;
            }

            visited = new int[v+1];

            bfs();
        }

        sc.close();   
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<Integer>();

        for (int start = 1; start <= v; start++) {
            if (visited[start] == 0) {
                que.offer(start);
                visited[start] = 1;
            }
    
            while (!que.isEmpty()) {
                int node = que.poll();
    
                for (int i = 1; i <= v; i++) {
                    if (graph[node][i] == 1) {
                        if (visited[i] == 0) {
                            que.offer(i);
                            visited[i] = visited[node] == 1 ? 2 : 1;
                        } else if (visited[i] == visited[node]) {
                            System.out.println("No");
                            return;
                        }
                    }
                } 
            }
        }

        System.out.println("Yes");
    }
    
}
