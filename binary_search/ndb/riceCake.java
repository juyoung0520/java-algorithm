package binary_search.ndb;
import java.util.*;

public class riceCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc. nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int)1e9;

        int result = 0;
        while (start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;
            
            for (int i : arr) {
                if (i > mid) sum += (i - mid);
            }

            if (sum < m) {
                end = mid - 1;    
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
