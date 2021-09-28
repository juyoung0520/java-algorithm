package dynamic_programming.boj;

import java.util.Scanner;

public class P10844 {

    final static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        long[][] dp = new long[1001][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j+1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][j-1] % mod;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        
        // (A+B) %C  와 (A%C + B%C)%C 결과 같음
        // 증명 https://st-lab.tistory.com/19
        System.out.println(sum % mod);
    }
    
}
