package dfs_bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class P2667 {
    
    static class Node {
        int a;
        int b;
    
        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
    }

    static int n;
    static boolean[][] graph;
    static boolean[][] visited;
    static ArrayList<Integer> town;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        graph = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {

            String str = br.readLine();

            for (int j = 1; j <= n; j++) {

                if (str.charAt(j-1) == '1') {
                    graph[i][j] = true;
                } 
            }
        }

        visited = new boolean[n+1][n+1];
        town = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] && !visited[i][j]) { 
                    town.add(bfs(i, j, 0));
                }
            }
        }

        Collections.sort(town);
        System.out.println(town.size());
        for (Integer house: town) {
            System.out.println(house);
        }

    }

    static int dfs(int a, int b, int count) {
        if (visited[a][b]) {
            return count;
        }

        visited[a][b] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x < 0 || x > n || y < 0 || y > n) {
                continue;
            }

            if (graph[x][y] && !visited[x][y]) {
                count = dfs(x, y, count);
            }
        }

        return count;
    }

    static int bfs(int a, int b, int count) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(a, b));
        visited[a][b] = true;
        count++;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.a + dx[i];
                int y = node.b + dy[i];

                if (x < 0 || x > n || y < 0 || y > n) {
                    continue;
                }

                if (graph[x][y] && !visited[x][y]) {
                    que.offer(new Node(x, y));
                    visited[x][y] = true;
                    count++;
                }
            }
        }

        return count;
    }

}
