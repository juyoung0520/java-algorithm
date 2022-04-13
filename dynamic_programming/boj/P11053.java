package dynamic_programming.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        } 

        // dp[i]는 numbers[i]를 마지막 원소로 가지는 증가하는 부분 수열의 최대 길이
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // 앞의 값이 다 안크면 dp[i] = 1
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                // j번째 원소가 i번째 보다 작으면서, dp[i]보다 dp[j] + 1가 더 클 경우 갱신
                if (numbers[j] < numbers[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

        }

        // 맨 마지막 원소의 dp가 최대값이란 보장 없음
        int max = 0;
        for(int i : dp) {
            max  = i > max ? i : max;
        }

        System.out.println(max);
    }
    
}
