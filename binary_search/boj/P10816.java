package binary_search.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816 {
    static int n, m;
    static int[] cards, finds;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cards = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        m = Integer.parseInt(br.readLine());
        
        finds = new int[m];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < m; i++) {
            finds[i] = Integer.parseInt(st.nextToken());
        }

        // 그냥 출력시 시간 초과
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            // upperBound는 값이 있을 경우 하나 큰 값에서 끝난다. lowerBound는 값이 있을 경우 제 자리에서 끝난다. 둘다 start를 반환했으므로. (그래서 +1 안해도 됨)
            bw.write(upperBound(i) - lowerBound(i)+" ");
        }

        bw.flush();
        bw.close();
    }

    static int upperBound(int i) {
        int start = 0;
        int end = n-1;
        // int res = 0;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (cards[mid] <= finds[i]) {
                // if (cards[mid] == finds[i]) {
                //     res = mid;
                // }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    static int lowerBound(int i) {
        int start = 0;
        int end = n-1;
        // int res = 0;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (cards[mid] < finds[i]) {
                start = mid + 1;
            } else {
                // if (cards[mid] == finds[i]) {
                //     res = mid;
                // }
                end = mid - 1;
            }
        }
        return start;
    }
    
}
