package dfs_bfs.boj;
import java.util.*;
/**
 * p2606
 */
public class p2606 {
    static int computer, connect, count = 0;
    static int[][] graph;
    static int[] visited;

    static void dfs(int com) {
        visited[com] = 1;

        for(int i= 0; i < graph[com].length; i++) {
            if(graph[com][i] == 1 && visited[i] == 0) {
                dfs(i);
                count++;
            }
        }
    }

    static void bfs(int com) {
        visited[com] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(com);

        while(!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int i = 0; i < graph[tmp].length; i++) {
                if (graph[tmp][i] == 1 && visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        computer = sc.nextInt();
        connect = sc.nextInt();

        graph = new int[computer+1][computer+1];
        visited = new int[computer+1];

        for(int i = 0; i < connect; i++)  {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // dfs(1);
        bfs(1);

        System.out.println(count);
        sc.close();
    }
    
}