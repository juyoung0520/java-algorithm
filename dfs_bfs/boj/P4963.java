package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4963 {
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            if (width + height == 0) {
                break;
            }

            graph = new boolean[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < width; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }

            int count = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (graph[i][j] && !visited[i][j]) {
                        dfs(new Node(i, j));
                        count++;
                    }
                }
            }

            sb.append(count + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Node start) {
        Queue<Node> que = new LinkedList<>();
        que.offer(start);

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 8; i++) {
                int a = node.getX() + dx[i];
                int b = node.getY() + dy[i];

                if (0 <= a && a < height && 0 <= b && b < width) {
                    if (graph[a][b] && !visited[a][b])  {
                        que.offer(new Node(a, b));
                        visited[a][b] = true;
                    }
                }
            }
        }
    }

    static void dfs(Node node) {
        if (visited[node.x][node.y]) {
            return;
        }

        visited[node.x][node.y] = true;

        for (int i = 0; i < 8; i++) {
            int a = node.getX() + dx[i];
            int b = node.getY() + dy[i];

            if (0 <= a && a < height && 0 <= b && b < width) {
                if (graph[a][b] && !visited[a][b])  {
                    dfs(new Node(a, b));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;   
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    
}
