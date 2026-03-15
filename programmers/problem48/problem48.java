package programmers.problem48;

import java.util.*;
class Solution {
    static int[] dx = {-1 ,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[] colsum = new int[m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    bfs(land, i, j, visited, colsum);
                }
            }
        }
        for(int col : colsum) {
            answer = Math.max(answer, col);
        }
        return answer;
    }
    public void bfs(int[][] land, int sx, int sy, boolean[][] visited, int[] colsum) {
        int n = land.length;
        int m = land[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        Set<Integer> col = new HashSet<>();
        col.add(sy);
        int size = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d = 0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(land[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                col.add(ny);
                size++;
            }
        }
        for(int c : col) {
            colsum[c] += size;
        }
    }
}
public class problem48 {
    public static void main(String[] args) {
        int[][] land = new int[][] {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        Solution sol = new Solution();
        System.out.println(sol.solution(land));
    }
}
