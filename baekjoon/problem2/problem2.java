package baekjoon.problem2;

import java.io.*;
import java.util.*;
public class problem2 {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;
    static void dfs(int node) {
        visited[node] = true;
        for(int next : tree.get(node)) {
            if(!visited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
}
