package dfs_bfs.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1707 {
    static int k, v, e;
    // 메모리 초과. ArrayList로 바꿔야될듯..
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            v = sc.nextInt();
            e = sc.nextInt();

            graph = new ArrayList[v+1];

            for (int j = 1; j <=v; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for (int j = 1; j <= e; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x].add(y);
                graph[y].add(x);
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
    
                for (int i = 0; i < graph[node].size(); i++) {
                    int closeNode = graph[node].get(i);

                    if (visited[closeNode] == 0) {
                        que.offer(closeNode);
                        visited[closeNode] = visited[node] == 1 ? 2 : 1;
                    } else if (visited[closeNode] == visited[node]) {
                        System.out.println("NO");
                        return;
                    }  
                } 
            }
        }

        System.out.println("YES");
    }
    
}
