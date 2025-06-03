package baekjoon.resign1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class resign1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int dp[][];
    static int benefit = -1;
    public static void main(String[] args) throws Exception{
        
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        for(int i = 1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(1, 0);
        System.out.println(benefit);
    }
    private static void dfs(int start, int money) {
        benefit = Math.max(benefit, money);
        if(start > n) {
            return;
        }
        if(start + dp[start][0] <=n+1) {
            dfs(start+dp[start][0], money+dp[start][1]);
        }
        dfs(start+1, money);

    }
}
