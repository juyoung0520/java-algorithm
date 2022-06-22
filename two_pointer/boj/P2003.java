package two_pointer.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
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

        int end = 0, sum = 0, cnt = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            while (end < n && sum < m) {
                sum += arr[end];
                end++;
            }

            if (sum == m) {
                cnt++;
            }

            sum -= arr[i];
        }

        //  while(true){
        //     if (sum >= m){
        //         sum -= arr[start];
        //         start++;
        //     } else if(end == n){
        //         break;
        //     } else {
        //         sum += arr[end];
        //         end++;
        //     }

        //     if(sum == m){
        //         cnt++;
        //     }
        // }

        System.out.println(cnt);
    }
}
