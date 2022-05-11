package string.programmers;

// 신규 아이디 추천
public class Kakao_2021_new_id {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^-_.0-9a-z]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
    
        if (new_id.length() == 0) {
            new_id = "a";
        } 
        
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        } else if (new_id.length() < 3) {
            while (new_id.length() != 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        return new_id;
    }
}
