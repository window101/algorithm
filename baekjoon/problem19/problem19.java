package baekjoon.problem19;

import java.io.*;
import java.util.*;

public class problem19 {
    static class Edge {
        int from, to, w;
        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge [] edges = new Edge[M];
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }
        final long INF = 9999999999L;
        long [] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i = 1; i<=N-1; i++) {
            for(Edge e : edges) {
                if(dist[e.from] == INF) continue;
                long nd = dist[e.from] + e.w;
                if(nd < dist[e.to]) {
                    dist[e.to] = nd;
                }
            }
        }
        for(Edge e : edges) {
            if(dist[e.from] == INF) continue;
            long nd = dist[e.from] + e.w;
            if(nd < dist[e.to]) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=N; i++) {
            if(dist[i] == INF) {
                sb.append(-1);
            }
            else {
                sb.append(dist[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
