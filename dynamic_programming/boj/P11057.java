package dynamic_programming.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11057 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long mod = 10007;

        // dp는 최대로 만들기
        long[][] dp = new long[1001][10];

        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < dp[0].length; j++) {

                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        int sum = 0;
        
        for (int j = 0; j < dp[0].length; j++) {
            sum += dp[n][j];
        }

        // (A + B) % C 랑 (A%C + B%C) % C랑 결과 같음.
        System.out.println(sum % mod);
    }
    
}
