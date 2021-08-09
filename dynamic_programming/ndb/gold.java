package dynamic_programming.ndb;
import java.util.*;

/**
 * gold
 */
public class gold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int n, m, left_top, left, left_down, res;

        for (int i = 0; i < tc; i++) {
            n = sc.nextInt();
            m = sc.nextInt();

            int graph[][] = new int[n][m];
            for (int j = 0; j < graph.length; j++) {
                for (int j2 = 0; j2 < graph[i].length; j2++) {
                    graph[j][j2] = sc.nextInt();
                }
            }
            
            for (int j = 1; j < m; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    left_top = (j2 == 0) ? 0 : graph[j2 - 1][j - 1];
                    left_down = (j2 == n - 1) ? 0 : graph[j2 + 1][j - 1];
                    left = graph[j2][j - 1];
                    
                    graph[j2][j] += Math.max(left, Math.max(left_down, left_top));
                }
            }

            res = 0;
            for (int j = 0; j < graph.length; j++) {
                res = Math.max(res, graph[j][m - 1]);
            }

            System.out.println(res);
        }

        sc.close();
    }
}