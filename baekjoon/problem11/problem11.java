package baekjoon.problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem11 {
    static int N;
    static ArrayList<Integer>[] children;
    static int deleteNode;
    static int leafCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        children = new ArrayList[N];
        for(int i = 0; i<N; i++) {
            children[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i = 0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
            }else {
                children[parent].add(i);
            }
        }
        deleteNode = Integer.parseInt(br.readLine().trim());
        if(deleteNode == root) {
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(leafCount);
    }
    static void dfs(int node) {
        if(node == deleteNode) {
            return;
        }
        int childCnt = 0;
        for(int next : children[node]) {
            if(next == deleteNode) {
                continue;
            }
            childCnt++;
            dfs(next);
        }
        if(childCnt == 0) {
            leafCount++;
        }
    }
}
