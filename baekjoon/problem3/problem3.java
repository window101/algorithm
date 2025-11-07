package baekjoon.problem3;

import java.io.*;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] board = new int[N][N];
        long [][] dp = new long[N][N];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                int val = board[i][j];
                if(val == 0) {
                    continue;
                }
                if(i+val < N) {
                    dp[i+val][j] += dp[i][j];
                }
                if(j+val < N) {
                    dp[i][j+val] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
