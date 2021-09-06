package greedy.programmers;

import java.util.stream.IntStream;

public class practice_kit_2 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String name = "JEROEN";
        System.out.println(solution.solution(name));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0, idx = 0;
            int left = 1, right = 1;
            char c;

            int[] ascii = new int[name.length()];
    
            for (int i = 0; i < name.length(); i++) {
                c = name.charAt(i);
                ascii[i] = ('Z' - c + 1) > c - 'A' ? c -'A' : ('Z' - c + 1);
            }
    
            while (true) {
                answer += ascii[idx];
                ascii[idx] = 0;
                if ((IntStream.of(ascii).sum()) == 0) return answer;
                left = 1;
                right = 1;
    
                while (((idx - left) >= 0) && ascii[idx - left] == 0) left += 1;
                while (((idx + right) < ascii.length) && ascii[idx + right] == 0) right += 1;
    
                idx = left >= right? right : left;
                answer += left >= right? right : left;
            }
        }
    }

}