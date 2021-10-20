package binary_search.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        int m = Integer.parseInt(br.readLine());
        
        int[] finds = new int[m];
        int[] res = new int[m];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < m; i++) {
            finds[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n-1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if  (cards[mid] == finds[i]) {
                    res[i] = 1;
                    break;
                } else if (cards[mid] < finds[i]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
    
}
