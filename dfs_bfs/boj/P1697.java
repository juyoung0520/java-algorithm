package dfs_bfs.boj;
import java.util.*;

/**
 * P1697
 */
public class P1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int MAX = 100000;
        int[] time = new int[MAX+1];
        
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        
        int current, next;
        while (!que.isEmpty()) {
            current = que.poll();

            if (current == k) {
                System.out.println(time[current]);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = current - 1;
                } else if (i == 1) {
                    next = current + 1;
                } else {
                    next = current * 2;
                }

                if (0 <= next && next <= MAX && time[next] == 0) {
                    time[next] = time[current] + 1;
                    que.add(next);
                }
            }
        }

        sc.close();
    }
}