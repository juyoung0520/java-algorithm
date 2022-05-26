package string.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Kakao_2018_file_name_sort
 * [3차] 파일명 정렬
 */
public class Kakao_2018_file_name_sort {

    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] arr1 = s1.split("[\\d]+");
                String[] arr2 = s2.split("[\\d]+");

                String head1 = arr1[0].toLowerCase();
                String head2 = arr2[0].toLowerCase();
        
                int compareRes = head1.compareTo(head2);
                if (compareRes != 0) {
                    return compareRes;
                }

                int num1 = findFirstNum(s1, head1.length());
                int num2 = findFirstNum(s2, head2.length());

                return num1 - num2;
            }
        });
    
        return files;
    }

    public int findFirstNum(String str, int start) {
        str = str.substring(start);
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;   
            }
            result += c;
        }
        
        return Integer.valueOf(result);
    }
}