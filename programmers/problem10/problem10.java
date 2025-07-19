package programmers.problem10;

import java.util.*;
class Solution {
    static class Truck {
        // 트럭마다 bridge_length => 2초 후에 다리를 지나게 시간 관리 필요
        int truck_time;
        int weight;
        public Truck(int truck_time, int weight) {
            this.truck_time = truck_time;
            this.weight = weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total_weight = 0;
        Queue<Integer> queue = new LinkedList<>(); // 대기 트럭
        Queue<Truck> bridge = new LinkedList<>(); // 다리를 건너는 트럭
        for(int i = 0; i<truck_weights.length; i++) {
            queue.add(truck_weights[i]);
        }
        while(!queue.isEmpty() || !bridge.isEmpty()) {
            answer++;
            
            if(!bridge.isEmpty() && (answer - bridge.peek().truck_time) == bridge_length) {
                total_weight -= bridge.peek().weight;
                bridge.poll();
            }
            if(!queue.isEmpty() && total_weight + queue.peek() <= weight ) {
                int truck_weight = queue.poll();
                total_weight += truck_weight;
                bridge.add(new Truck(answer, truck_weight));
            }
        }
        return answer;
    }
}

public class problem10 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7, 4, 5, 6};
        Solution sol = new Solution();
        System.out.println(sol.solution(bridge_length, weight, truck_weights));
    }
}
