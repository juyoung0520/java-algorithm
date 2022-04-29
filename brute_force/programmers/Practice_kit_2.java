package brute_force.programmers;

import java.util.ArrayList;

public class Practice_kit_2 {
    static int count = 0;
    static ArrayList<Integer> numArray = new ArrayList<>();

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    static int solution(String numbers) {
        int n = numbers.length();
        char[] arr = new char[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i);
        }

        for (int i = 1; i <= n ; i++) {
            dfs(i, 0, arr, visited, new char[i]);
        }

        for (int num : numArray) {
            isPrime(num);
        }
 
        return count;
    }

    static void isPrime(int num) {
        if (num < 2) return;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return;
        }

        count++;
    }

    static void dfs(int m, int index, char[] arr, boolean[] visited, char[] res) {
        if (m == index) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]);
            }
            
            int num = Integer.parseInt(sb.toString());
            if (!numArray.contains(num)) {
                numArray.add(num);
            }
        
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[index] = arr[i];
                dfs(m, index + 1, arr, visited, res);
                visited[i] = false;
            }
        }
    }
}
