package dfs_bfs.boj;
import java.util.*;

/**
 * p7569
 */

public class p7569 {
    static Queue<Node> que = new LinkedList<>();
    static int[][][] graph = new int[100][100][100];
    static int m, n, h;

    static class Node {
        private int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

    static int bfs() {
        int days = -1;
        int size = 0;
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while (!que.isEmpty()) {
            days += 1;
            size = que.size();

            // 큐의 size로 줬다가 큐가 변하면서 이상하게 돔;;
            for (int i = 0; i < size; i++) {
                Node tmp = que.poll();

                for (int j = 0; j < 6; j++) {
                    int nx = tmp.getX() + dx[j];
                    int ny = tmp.getY() + dy[j];
                    int nz = tmp.getZ() + dz[j];

                    if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && (0 <= nz && nz < h) && graph[nz][nx][ny] == 0) {
                        graph[nz][nx][ny] += 1;
                        que.offer(new Node(nx, ny, nz));
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 0) return -1;
                }
            }
        }

        return days;
    }
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    graph[i][j][k] = sc.nextInt();
                }
                sc.nextLine();
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 1) {
                        que.offer(new Node(j, k, i));
                    }
                }
            }
        }

        System.out.println(bfs());
        sc.close();
    }
    
}