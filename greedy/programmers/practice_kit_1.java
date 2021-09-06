package greedy.programmers;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = 0;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if (people[i] >= 1) {
                if (i-1 >= 0 && people[i-1] == -1) {
                    people[i]--;
                    people[i-1]++;
                } else if (i+1 < people.length && people[i+1] == -1) {
                    people[i]--;
                    people[i+1]++;
                }
            }
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] >= 0)
                answer++;
        }

        return answer;
    }
}

public class practice_kit_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        
        System.out.println(s.solution(n, lost, reserve));
    }

    
}