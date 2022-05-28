package implement.programmers;

/**
 * Kakao_2018_n_number_game
 * n진수 게임
 */
public class Kakao_2018_n_number_game {
    public String solution(int n, int t, int m, int p) {
        // 문자열 구하기
        StringBuilder str = new StringBuilder("0");
        int number = 0;
        
        while (str.length() < t * m) {
            StringBuilder sb = new StringBuilder();
            int num = number++;
            
            while (num > 0) {
                int res = num % n;
                if (res >= 10) {
                    sb.append((char)(res + ('A' - 10)));
                } else {
                    sb.append(res);
                }
                num /= n;
            }
            
            str.append(sb.reverse().toString());
        }
        
        // 문자 뽑기 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(str.charAt(m * i + p - 1) + "");
        }
        
        return sb.toString();
    }
    
}