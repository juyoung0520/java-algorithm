package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.event.PrintEvent;

public class P7576 {
    static int m, n; // m 은 column, n은 row

    static int[][] graph;
    static int[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    visited[i][j] = -1;
                }
            }
        }

        bfs();
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0;  j < m; j++) {
                if (visited[i][j] == 0) {
                    System.out.println("-1");
                    return;
                } else {
                    max = Math.max(max, visited[i][j]);
                }
            }
        }


        // 첫 날을 1로 보니까 -1
        System.out.println(max-1);
    }

    static void bfs() {
        Queue<Node> que = new LinkedList<>();

        // 동시에 연결리스트 찾는 효과!!
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    que.offer(new Node(i, j));
                    visited[i][j] = 1;
                } 
            }
        }

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int a = node.x + dx[i];
                int b = node.y + dy[i];

                if (0 <= a && a < n && 0 <= b && b < m) {
                    if (graph[a][b] == 0 && visited[a][b] == 0) {
                        que.offer(new Node(a, b));
                        visited[a][b] = visited[node.x][node.y] + 1;
                    }
                }
            }
        }

    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}
