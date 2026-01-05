package baekjoon.problem18;

import java.io.*;
import java.util.*;

public class problem18 {
    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    static class Node implements Comparable<Node> {
        int v;
        int dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.dist, node.dist);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine().trim());

        List<Edge>[] graph = new ArrayList[V+1];
        for(int i = 1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v; // 지금 도착한 정점
            int d = cur.dist; // 시작점부터 여기까지의 거리
            if(d!=dist[u]) continue;
            for(Edge e : graph[u]) {
                int v = e.to;
                int nd = d + e.w;
                if(nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new Node(v, nd));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=V; i++) {
            if(dist[i] == INF) {
                sb.append("INF\n");
            }else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
