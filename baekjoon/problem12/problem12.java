package baekjoon.problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem12 {
    static int N;
    static int[] arr;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new ArrayList[N+1];
        for(int i = 1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dp = new int[N+1][2];
        visited = new boolean[N+1];
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    static void dfs(int node) {
        visited[node] = true;
        dp[node][1] += arr[node];
        for(int next : tree[node]) {
            if(!visited[next]) {
                dfs(next);
                dp[node][1] += dp[next][0];
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
            }
        }
    }
}
