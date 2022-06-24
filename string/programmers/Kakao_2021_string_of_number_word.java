package string.programmers;

import dynamic_programming.ndb.soldier;

public class Kakao_2021_string_of_number_word {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
