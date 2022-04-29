package implement.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2980 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
            array[i][2] = Integer.parseInt(st.nextToken());
        }

        int t = array[0][0];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                t = array[0][0];
            } else {
                t += array[i][0] - array[i-1][0];
            }

            int tmp = t;
            int r= array[i][1];
            int g = array[i][2];

            if (t > r + g) {
                tmp = tmp % (r + g);
            }

            if(tmp < r) {
                t += r - tmp;
            } 
        }

        // 마지막 신호등 ~ 목착지
        t += l - array[n-1][0];

        System.out.println(t);

        br.close();
    }
}
