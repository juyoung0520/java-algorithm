package string.programmers;

public class kakao_2020_string_compression {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
    
        for (int i = 0; i <= (s.length() / 2); i++) {   
            answer = Math.min(answer, compression(s, i + 1));
        }
        
        return answer;
    }
    
    public int compression(String s, int i) {
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        int count = 1;
        
        for (int j = 0; j < s.length() / i; j++) {
            String sub = s.substring(j * i, j * i + i);

            if (tmp.equals(sub)) {
                count++;
                continue;
            } 
            
            if (count > 1) {
                sb.append(count + tmp);
                count = 1;
            } else {
                sb.append(tmp);
            }
            
            tmp = sub; 
        }
        
        if (count > 1) {
            sb.append(count + tmp);
            count = 1;
        } else {
            sb.append(tmp);
        }
        
        if (s.length() % i != 0) {
            sb.append(s.substring(s.length() - s.length() % i, s.length()));
        }
        
        return sb.length();
    }
}
