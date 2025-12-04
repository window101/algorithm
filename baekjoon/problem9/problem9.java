package baekjoon.problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] val = new int[N+1];
        int [] dp = new int[N+1];

        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            val[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1) {
            System.out.println(val[1]);
            return;
        }

        if(N == 2) {
            System.out.println(val[1] + val[2]);
            return;
        }
        dp[1] = val[1];
        dp[2] = val[1] + val[2];
        dp[3] = Math.max(val[1]+val[3], val[2]+val[3]);

        for(int i = 3; i<=N; i++) {
            dp[i] = Math.max(dp[i-2] + val[i], dp[i-3] + val[i-1] + val[i]);
            //dp[i] = Math.max(dp[i], dp[i-3] + val[i-2] + val[i]); 이건 dp[i-2] + val[i] 에서 표현되어서 중복임
        }
        System.out.println(dp[N]);
    }
}
