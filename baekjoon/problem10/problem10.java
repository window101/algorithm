package baekjoon.problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int [] arr = new int[N];
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add(arr[i]);
        }
        long res = 0L;
        int cnt = 1;
        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            if((tmp - (cnt -1)) < 0) {
                break;
            }
            res += (tmp - (cnt -1));
            cnt++;
        }
        System.out.println(res);
    }
}
