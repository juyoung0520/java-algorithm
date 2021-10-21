package divide_conquer.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P11728
 */
public class P11728 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] mergeArray = new int[n+m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergeArray[k++] = arr1[i++];
            } else {
                mergeArray[k++] = arr2[j++];
            }
        }

        while (i < n)  {
            mergeArray[k++] = arr1[i++];
        }

        while (j < m)  {
            mergeArray[k++] = arr2[j++];
        }

        StringBuilder sb = new StringBuilder();
        for (int num : mergeArray) {
            sb.append(num+" ");
        }

        System.out.println(sb.toString());
    }
    
        
}