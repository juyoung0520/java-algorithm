package binary_search.programmers;
import java.util.*;
/**
 * practice_kit_1
 */
public class practice_kit_1 {

    public static void main(String[] args) {
        int n = 6;
        int times[] = {7, 10};
        Solution solu = new Solution();
        System.out.println(solu.solution(n, times));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            long start = 1;

            Arrays.sort(times);
            // 캐스팅 유무로 시간 차이 많이 나나 봄..
            long end = (long) n * times[times.length - 1];
            long mid, count;

            while (start <= end) {
                mid = (start + end) / 2;
                count = 0;

                for (int time: times) {
                    count += mid / time;
                    if (count >= n) break;
                }
    
                if (count < n) {
                    start = mid + 1;
                } else {
                    answer = mid;
                    end = mid - 1;
                }
    
            }
            
            return answer;
        }
    }
}