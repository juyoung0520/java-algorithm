package dynamic_programming.boj;

import java.util.Scanner;

/**
 * P2193
 */
public class P2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        sc.close();

        // int 배열로 선언하면 오류
        // int 범위  -2,147,483,648 ~ 2,147,483,647. 약 10자리
        long[][] dp = new long[91][2];

        dp[1][1] = 1;
        dp[2][0] = dp[1][1];

        // i 초기화 주의
        for (int i = 3; i <= n; i++) {

            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];   
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}