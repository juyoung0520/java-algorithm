package dynamic_programming.boj;

import java.util.Scanner;

public class P2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] wine = new int[n+1];

        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        sc.close();

        int[] dp = new int[10001];
        dp[1] = wine[1];
        if (n > 1)
            dp[2] = wine[1] + wine[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
        }

        System.out.println(dp[n]);
    }
}
