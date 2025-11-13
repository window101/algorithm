package baekjoon.problem5;

import java.util.*;

public class problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] visit = new int[100001];
        visit[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == K) {
                System.out.println(visit[now]);
                break;
            }
            int [] nextList = {now-1, now+1, now*2};
            for(int next : nextList) {
                if(next >= 0 && next <= 100000 && visit[next] == 0) {
                    visit[next] = visit[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
