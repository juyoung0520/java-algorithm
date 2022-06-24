package implement.programmers;

public class Kakao_2018_4blocks {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }

        while (true) {
            int res = findBlocks(arr);
            
            if (res == 0) {
                break;
            }

            answer += res;

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (arr[i][j] == '.'){
                        for (int r = i - 1; r >= 0; r--) {
                            if (arr[r][j] != '.') {
                                arr[i][j] = arr[r][j];
                                arr[r][j] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static int findBlocks(char[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] != '.')  {
                    checkAround(arr, visited, i, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (visited[i][j]) {
                    count++;
                    arr[i][j] = '.';
                }
            }
        }

        return count;
    }

    public static void checkAround(char[][] arr, boolean[][] visited, int i, int j) {
        char block = arr[i][j];

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                if (block != arr[r][c]) {
                    return;
                }
            }
        }

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                if (!visited[r][c]) {
                    visited[r][c] = true;
                }
            }
        }
    }
}
