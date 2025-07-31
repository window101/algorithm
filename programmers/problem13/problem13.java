package programmers.problem13;

class Solution {
    static boolean[] visited;
    static boolean[][] graph;
    private static void dfs(int indx, int[][] computers, int n) {
        visited[indx] = true;
        for(int i = 0; i<n; i++) {
            if(!visited[i] && computers[indx][i] == 1) {
                dfs(i, computers, n);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }
        return answer;
    }
}
public class problem13 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution sol = new Solution();
        System.out.println(sol.solution(n, computers));
    }
}
