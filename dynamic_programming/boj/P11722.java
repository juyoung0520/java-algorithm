package dynamic_programming.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] 는 i번째 원소로 끝나는 감소하는 부분 수열 
        // 초기값 설정 없어서 n개만 할당해도 됨.
        int[] dp = new int[n];

        // 이렇게 해도 되고, 맨 뒤부터 돌아서 증가하는 수열 구해도 됨.
        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                // 자기 앞의 원소 중에 자기보다 큰 값 있으면 검사
                if (seq[j] > seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int length : dp) {
            max = max < length ? length : max;
        }

        System.out.println(max);
    }
    
}
