package two_pointer.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0, sum = 0, cnt = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            while (end < n && sum < m) {
                sum += arr[end];
                end++;
                cnt++;
            }

            if (sum >= m) {
                min = Math.min(min, cnt);
            }

            sum -= arr[i];
            cnt--;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
