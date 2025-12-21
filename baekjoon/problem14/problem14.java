package baekjoon.problem14;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem14 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();
        int[] trucks = new int[n];
        for(int i = 0; i<n; i++) {
            trucks[i] = sc.nextInt();
        }
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i<w; i++) {
            bridge.offer(0);
        }
        int index = 0;
        int time = 0;
        int sum = 0;
        while(n > index) {
            time++;
            int tmp = bridge.poll();
            sum -= tmp;
            if(sum + trucks[index] <= L) {
                sum += trucks[index];
                bridge.offer(trucks[index]);
                index++;
            }else {
                bridge.offer(0);
            }
        }
        System.out.println(time+w);
    }
}
