package backtracking.programmers;

import java.util.ArrayList;
import java.util.List;

public class Kakao_2020_expression_max {
    static long max = Long.MIN_VALUE;
    static char[] operators = {'+', '*', '-'};
    static List<Long> arrNum = new ArrayList<>();
    static List<Character> arrOp = new ArrayList<>();
    static List<Character> periority = new ArrayList<>();

    public static long solution(String expression) {
        int lastIdx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == operators[0] || c == operators[1] || c == operators[2]) {
                arrNum.add(Long.parseLong(expression.substring(lastIdx, i)));
                arrOp.add(c);
                lastIdx = i + 1; // 디음 숫자 시작 인덱스
            }
        }
        arrNum.add(Long.parseLong(expression.substring(lastIdx))); //마지막 숫자 넣기
        
        dfs(expression, 0);

        return max;
    }

    public static void dfs(String expression, int idx) {
        if (idx == operators.length) {
            // 원본 보존하기 위해
            List<Long> arrNum1  = new ArrayList<>(arrNum);
            List<Character> arrOp1 = new ArrayList<>(arrOp);

            for (int i = 0; i < periority.size(); i++) {
                for (int j = 0; j < arrOp1.size(); j++) {
                    // 현재 우선순위 연산자일 경우
                    if (arrOp1.get(j) == periority.get(i)) {
                        Long result = calculation(arrNum1.remove(j), arrNum1.remove(j), periority.get(i));
                        arrNum1.add(j, result);
                        arrOp1.remove(j);
                        j--;
                    }
                }
            }

            max = Math.max(Math.abs(arrNum1.get(0)), max);
            return;
        }

        // 연산자 우선 순위 정하기
        for (int i = 0; i < operators.length; i++) {
            if (!periority.contains(operators[i])) {
                periority.add(operators[i]);
                dfs(expression, idx + 1);
                periority.remove(periority.size() - 1);
            }
        }
    }

    public static long calculation(long num1, long num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '*':
                return num1 * num2;
            case '-':
                return num1 - num2;
        }
        return 0;
    }
}
