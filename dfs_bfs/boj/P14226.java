package dfs_bfs.boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


/**
 * P14226
 */
public class P14226 {
    static int s;
    // 화면, 클립보드의 이모티콘 개수 상태 배열
    static boolean[][] visited = new boolean[2001][2001];

    static class Emo {
        int screen;
        int clip;
        int time;

        public Emo(int screen, int clip, int time) {
            this.screen = screen;
            this.clip = clip;
            this.time = time;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        Queue<Emo> que = new LinkedList<>();

        que.offer(new Emo(1, 0, 0));

        while(!que.isEmpty()) {
            Emo e = que.poll();

            if (e.screen == s) {
                System.out.println(e.time);
                break;
            }

            // 붙여넣기
            // 클립보드 안비고, 붙여넣기 후 이모티콘 개수 1000개 이하이고, 방문안했을 때
            if (e.clip != 0 && e.screen + e.clip <= 1000 && !visited[e.screen + e.clip][e.clip]) {
                que.offer(new Emo(e.screen + e.clip, e.clip, e.time+1));
                visited[e.screen + e.clip][e.clip] = true;
            }

            // 복사
            // 화면이랑 클립보드 이모티콘 수 다를 때 복사
            if (e.screen != e.clip && !visited[e.screen][e.screen]) {
                que.offer(new Emo(e.screen, e.screen, e.time+1));
                visited[e.screen][e.screen] = true;
           }

           // 삭제
           if (e.screen > 0 && !visited[e.screen-1][e.clip]) {
               que.offer(new Emo(e.screen-1, e.clip, e.time+1));
               visited[e.screen-1][e.clip] = true;
           }

           br.close();
        }
    }
}