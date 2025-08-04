package programmers.problem14;

class Solution {
    static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    public void dfs(int depth, int k, int[][] dungeons) {
        for(int i = 0; i<dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}
public class problem14 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 80;
        int[][] dungeons = new int[][] {{80,20},{50,40},{30,10}};
        System.out.println(sol.solution(k, dungeons));
    }
}
