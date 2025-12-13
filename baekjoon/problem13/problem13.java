package baekjoon.problem13;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem13 {
    static int w;
    static int h;
    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {-1, 0, 1, 1, -1, -1, 0, 1};
    static int arr[][];
    static int count;
    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) { 
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) {
                return;
            }
            arr = new int[h][w];
            for(int i = 0; i<h; i++) {
                for(int j = 0; j<w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            count = 0;
            for(int i = 0; i<h; i++) {
                for(int j = 0; j<w; j++) {
                    if(arr[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void bfs(int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(j, i));
        while(!queue.isEmpty()) {
            Pos tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            for(int k =0; k<8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < w && ny >= 0 && ny <h && arr[ny][nx] == 1) {
                    queue.offer(new Pos(nx, ny));
                    arr[ny][nx] = 0;
                }
            }
        }
    }
}
