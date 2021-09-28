package dynamic_programming.boj;

import java.util.Scanner;

public class P11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        // 2보다 n이 작으면 runtime error
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = dp[1] + 2;

        // 나머지 연산을 한 결과값을 출력해야할 때는
        // 반드시 연산할 때마다 나머지 연산. 아니면 이상한 값 출력
        for (int i = 3;  i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
