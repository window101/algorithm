package programmers.problem51;

import java.util.*;

class Solution {
    static char[][] map;
    static int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        map = new char[n+2][m+2];
        for(int i = 0; i<n+2; i++) {
            Arrays.fill(map[i], '.');
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        for(String req : requests) {
            char target = req.charAt(0);
            if(req.length() == 2) {
                crane(target);
            }else {
                forklift(target);
            }
        }
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                if(map[i][j] != '.') {
                    answer++;
                }
            }
        }
        return answer;
    }
    void crane(char target) {
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                if(map[i][j] == target) {
                    map[i][j] = '.';
                }
            }
        }
    }
    void forklift(char target) {
        boolean[][] visited = new boolean[n+2][m+2];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> removeList = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d = 0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= n+2 || ny < 0 || ny >= m+2) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == '.') {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
                if(map[nx][ny] == target) {
                    removeList.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        for(int[] pos : removeList) {
            map[pos[0]][pos[1]] = '.';
        }
    }
}
public class problem51 {
    public static void main(String[] args) {
        String[] storage = new String[] {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = new String[] {"A", "BB", "A"};
        Solution sol = new Solution();
        System.out.println(sol.solution(storage, requests));
    }
}