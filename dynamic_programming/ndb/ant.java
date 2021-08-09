package dynamic_programming.ndb;

import java.util.*;

public class ant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int store[] = new int[n];
        for (int i = 0; i < store.length; i++) {
            store[i] = sc.nextInt();
        }

        // i번 식량 창고까지의 최적 해
        int dp[] = new int[100];
        dp[0] = store[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + store[i]);
        }
        System.out.println(dp[n-1]);
        sc.close();
    }
    
}
