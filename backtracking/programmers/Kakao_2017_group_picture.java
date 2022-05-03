package backtracking.programmers;

public class Kakao_2017_group_picture {
    int answer = 0;
    
    public int solution(int n, String[] data) {
        char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        boolean[] visited = new boolean[arr.length];
        dfs("", arr, visited, data);
        return answer;
    }
    
    public void dfs(String str, char[] arr, boolean[] visited, String[] data) {
        if (str.length() == arr.length) {
            if (checkValid(str, data)) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str+arr[i], arr, visited, data);
                visited[i] = false;
            }
        }
    }
    
    public boolean checkValid(String str, String[] data) {
            for (String d : data) {
            int firstIdx = str.indexOf(d.charAt(0));
            int secondIdx = str.indexOf(d.charAt(2));
            char op = d.charAt(3);
            int interval = d.charAt(4) - '0';
                
            if (op == '=') {
                if (Math.abs(firstIdx - secondIdx) != interval + 1) {
                    return false;
                }
            } else if (op == '<') {
                if (Math.abs(firstIdx - secondIdx) >= interval + 1) {
                        return false;
                }
            } else if (op == '>') {
                if (Math.abs(firstIdx - secondIdx) <= interval + 1) {
                        return false;
                }
            }
        }
        
        return true;
    }
}
