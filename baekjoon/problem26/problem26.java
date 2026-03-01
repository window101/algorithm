package baekjoon.problem26;

import java.io.IOException;
import java.util.Scanner;

public class problem26 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] dp = new int[N+1];
        int [] p = new int[N+1];

        for(int i = 1; i<=N; i++) {
            p[i] = sc.nextInt();
        }
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
