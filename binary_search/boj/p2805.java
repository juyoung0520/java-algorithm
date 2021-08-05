package binary_search.boj;
import java.util.Scanner;
/**
 * p2805
 */
public class p2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tree = new int[n];
    
        for (int i = 0; i < tree.length; i++) {
          tree[i] = sc.nextInt();
        }
    
        int start = 0;
        int mid = 0;
        long res = 0;
        long sum = 0;
        int end = (int)1e9;
    
        while (start <= end) {
          sum = 0;
          mid = (start + end) / 2;
    
          for (int i: tree) {
            if (i > mid) sum += (i - mid);
          }
    
          if (sum < m) {
            end = mid - 1;
          } else {
            res = mid;
            start = mid + 1;
          }
        }
    
        System.out.println(res);
        sc.close();
      }

    
}