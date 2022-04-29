package dfs_bfs.programmers;

import java.util.Arrays;

public class Kakao_2017_colorBook {
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
        visited = new boolean[picture.length][picture[0].length];
        System.out.println(Arrays.toString(solution(6, 4, picture)));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j] ) {
                    visited[i][j] = true;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j, picture));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int dfs(int x, int y, int[][] picture) {
        int value = picture[x][y];
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];

            if (0 <= x2 && x2 < picture.length && 0 <= y2 && y2 < picture[0].length && picture[x2][y2] == value && !visited[x2][y2]) {
                visited[x2][y2] = true;
                area += dfs(x2, y2, picture);
            }
        }

        return area;
    }
    
}
