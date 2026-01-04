package programmers.problem40;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int max_val = 0;
        int n = park.length;
        int m = park[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(!park[i][j].equals("-1")) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
                if(dp[i][j] > max_val) {
                    max_val = dp[i][j];
                }
            }
        }
        int answer = -1;
        for(int a : mats) {
            if(a <= max_val) {
                answer = Math.max(answer, a);
            }
        }
        return answer;
    }
}
public class problem40 {
    public static void main(String[] args) {
        int[] mats = new int[] {5,3,2};
        String[][] park = new String[][] {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        Solution sol = new Solution();
        System.out.println(sol.solution(mats, park));
    }
}
