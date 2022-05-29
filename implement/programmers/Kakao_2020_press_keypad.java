package implement.programmers;

public class Kakao_2020_press_keypad {
    int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2},
    {1, 0}, {1, 1}, {1, 2},
    {2, 0}, {2, 1}, {2, 2}
   };

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = {3, 0};
        int[] right =  {3, 2};

        for (int n : numbers) {
            int res = n % 3;

            if (res == 1) {
                sb.append('L');
                left[0] = keypad[n][0];
                left[1] = keypad[n][1];
            } else  if (res == 2 || n == 0) {
                int l = calcDistance(left, n);
                int r = calcDistance(right, n);
                
                if (l == r) {
                    if (hand.equals("left")) {
                        l--;
                    } else {
                        r--;
                    }
                }
                
                if (l > r) {
                    sb.append('R');
                    right[0] = keypad[n][0];
                    right[1] = keypad[n][1];
                } else {
                    sb.append('L');
                    left[0] = keypad[n][0];
                    left[1] = keypad[n][1];
                }
            } else if (res == 0) {
                sb.append('R');
                right[0] = keypad[n][0];
                right[1] = keypad[n][1];
            }
        }   

        return sb.toString();   
    }

    public int calcDistance(int[] from, int to) {
        return Math.abs(from[0] - keypad[to][0]) + Math.abs(from[1] - keypad[to][1]);
    }
}
