package dynamic_programming.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n+1];
        int[] prices = new int[n+1];
        
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[5*n + 1];
        for (int i = n; i >= 1; i--) {
            int nextDay = i + times[i];
            
            if (nextDay > n+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], prices[i] + dp[nextDay]);
            }
        }

        System.out.println(dp[1]);

        br.close();
    }
    
}
