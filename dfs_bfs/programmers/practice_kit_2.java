package dfs_bfs.programmers;

import java.util.*;
/**
 * pratice_kit_2
 */
public class practice_kit_2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.solution(n, computers));
    }

    static class Solution {
        int[] visited;

        public void bfs(int start, int[][] com) {
            Queue<Integer> que = new LinkedList<>();
            que.offer(start);
            visited[start] = 1;

            while(!que.isEmpty()) {
                int tmp = que.poll();

                for(int i = 0; i < com[tmp].length; i++) {
                    if (com[tmp][i] == 1 && visited[i] == 0) {
                        visited[i] = 1;
                        que.offer(i);
                    } 
                }
            }

        }

        public void dfs(int start, int[][] com) {
            visited[start] = 1;

            for (int i = 0; i < com[start].length; i++) {
                if (visited[i] == 0 && com[start][i] == 1) 
                    dfs(i, com);
            }
        }

        public int solution(int n, int[][] computers) {
            int answer = 0;
            visited = new int[computers[0].length];

            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    bfs(i, computers);
                    answer++;
                }
            }

            return answer;
        }
        
    }
}