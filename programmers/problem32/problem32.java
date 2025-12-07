package programmers.problem32;
import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int INF = 1_000_000_000;

        int [][] dp = new int[len+1][n];

        for(int i = 0; i<=len; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for(int i = 0; i<len; i++) {
            int aCost = info[i][0];
            int bCost = info[i][1];
            for(int a = 0; a<n; a++) {
                if(dp[i][a] == INF) continue;
                int bSum = dp[i][a];

                // a가 훔치는 경우
                int nextA = a + aCost;
                if(nextA < n) {
                    if(dp[i+1][nextA] > bSum) {
                        dp[i+1][nextA] = bSum;
                    }
                }
                // b가 훔치는 경우
                int nextB = bSum + bCost;
                if(nextB < m) {
                    if(dp[i+1][a] > nextB) {
                        dp[i+1][a] = nextB;
                    }
                }
            }
        }
        int answer = -1;
        for(int a = 0; a<n; a++) {
            if(dp[len][a] < m) {
                answer = a;
                break;
            }
        }
        return answer;
    }
}
public class problem32 {
    public static void main(String[] args) {
        int[][] info = new int[][] {{1,2}, {2,3}, {2,1}};
        int n = 4;
        int m = 4;
        Solution sol = new Solution();
        System.out.println(sol.solution(info, n, m));
    }
}
