package implement.programmers;

/**
 * Kakao_2020_braket
 */
public class Kakao_2020_braket {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }

    public static String solution(String p) {
        return recursive(p);
    }

    public static String recursive(String str) {
        if (str.length() == 0) {
            return "";
        }

        int idx = getSeperateIdx(str);
        String u = str.substring(0, idx+1);
        String v = str.substring(idx+1);

        if (!isCorrectString(u)) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(recursive(v));
            sb.append(")");
            String tmp = u.substring(1, u.length()-1);
            sb.append(reverse(tmp));
            return sb.toString();
        }
        
        return u + recursive(v);
    }

    public static int getSeperateIdx(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                return i;
            }
        }
        return str.length()-1;
    }

    public static boolean isCorrectString(String u) {
        if (u.length() == 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);

            if (c == '(') {
                count++;
            } else {
                count--;
            }
            
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            
            if (c == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
}