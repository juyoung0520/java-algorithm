package input.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n+1];

        for (int i = 0; i < m; i++) {
            String condition = br.readLine();

            StringTokenizer st2 = new StringTokenizer(condition, " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            for (int j = a; j <= b; j++) {
                basket[j] = c;
            }
        }

        for (int i = 1;  i < n+1; i++) {
            System.out.print(basket[i]+" ");
        }

        System.out.println();
    }
    
}
