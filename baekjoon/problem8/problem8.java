package baekjoon.problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] W = new int[N+1];
        int [] V = new int[N+1];
        int [][] dp = new int[N+1][K+1];
        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N; i++) {
            for(int w = 0; w<=K; w++) {
                dp[i][w] = dp[i-1][w];
                if(w - W[i] >= 0) {
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w-W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
