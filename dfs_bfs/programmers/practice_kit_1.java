package dfs_bfs.programmers;


public class practice_kit_1 {
    static int[] numbers = {1, 1, 1, 1, 1};
    static int target = 3;

    public static void main(String[] args) {
        Solution solu = new Solution();
        System.out.println(solu.solution(numbers, target));
    }

    static class Solution {
        public int dfs(int i, int sum, int[] numbers, int target) {
            int answer = 0;

            if (i == numbers.length) {
                if (sum == target) return 1;
                return 0;
            }

            answer += dfs(i + 1, sum + numbers[i], numbers, target);
            answer += dfs(i + 1, sum - numbers[i], numbers, target);

            return answer;
        }

        public int solution(int[] numbers, int target) {
            int answer = 0;
            answer += dfs(0, 0, numbers, target);
            return answer;
        }
        
    }
    
}
