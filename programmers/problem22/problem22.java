package programmers.problem22;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int index = 0;
        int hp_time = 0;
        for(int i = 1; i<=attacks[attacks.length-1][0]; i++) {
            if(i == attacks[index][0]) {
                hp -= attacks[index][1];
                if(hp <= 0) return -1;
                index++;
                hp_time = 0;
            }else {
                hp_time++;
                hp += bandage[1];
                if(hp_time == bandage[0]) {
                    hp += bandage[2];
                    hp_time = 0;
                }
                if(hp >= health) hp = health;
            }
        }
        return hp;
    }
}
public class problem22 {
    public static void main(String[] args) {
        int[] bandage = new int[] {5,1,5};
        int health = 30;
        int[][] attacks = new int[][]{{2,10}, {9,15}, {10,5}, {11,5}};
        Solution sol = new Solution();
        System.out.println(sol.solution(bandage, health, attacks));
    }
}
