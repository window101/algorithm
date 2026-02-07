package baekjoon.problem24;

import java.io.*;
import java.util.StringTokenizer;

public class problem24 {
    static int N;
    static int[] arr;
    static int[] op = new int[4];
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, arr[0]);
        System.out.println(maxVal);
        System.out.println(minVal);
    }
    static void dfs(int idx, int cur) {
        if(idx == N) {
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }
        int next = arr[idx];
        for(int i = 0; i<4; i++) {
            if(op[i] == 0) continue;
            op[i]--;
            int newVal = apply(cur, next, i);
            dfs(idx+1, newVal);
            op[i]++;
        }
    }
    static int apply(int x, int y, int type) {
        switch(type) {
            case 0 :
                return x + y;
            case 1 :
                return x - y;
            case 2 :
                return x * y;
            case 3 :
                if( x< 0) return -(Math.abs(x) / y);
                return x / y;
        }
        return 0;
    }
}
