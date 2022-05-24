package dfs_bfs.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Kakao_2021_keep_distance
 * 거리두기 확인하기
 */
public class Kakao_2021_keep_distance {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];
            
            boolean isOk = true;
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (p[r].charAt(c) == 'P') {
                        if (!bfs(p, r, c)) {
                            isOk = false;
                        }
                    }
                }
            }
            
            answer[i] = isOk ? 1 : 0;
            
        }
        return answer;
    }
    
    public boolean bfs(String[] p, int r, int c) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {r, c, 1});
        
        while (!que.isEmpty()) {
            int[] position = que.poll();
                
            for (int i = 0; i < 4;  i++) {
                int nr = position[0] + dx[i];
                int nc = position[1] + dy[i];
                
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && (nr != r || nc != c)) { 
                    if (p[nr].charAt(nc) == 'P') {
                        return false;
                    } else if (p[nr].charAt(nc) == 'O' && position[2] == 1) {
                        que.offer(new int[] {nr, nc, 0});
                    }
                }
            }
        }
        
        return true;
    }
}