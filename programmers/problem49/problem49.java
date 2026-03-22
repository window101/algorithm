package programmers.problem49;

import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int rows = n/w;
        if(n%w != 0) {
            rows++;
        }
        int[][] arr = new int[rows][w];
        for(int i = 0; i<rows; i++) {
            Arrays.fill(arr[i], -1);
        }
        int current = 1;
        int targetCol = -1;
        int targetRow = -1;
        for(int r = 0; r<rows; r++) {
            if(r % 2 == 0) {
                for(int c = 0; c<w; c++) {
                    if(current > n) break;
                    arr[r][c] = current;
                    if(arr[r][c] == num) {
                        targetCol = c;
                        targetRow = r;
                    }
                    current++;
                }
            }else {
                for(int c = w-1; c>=0; c--) {
                    if(current > n) break;
                    arr[r][c] = current;
                    if(arr[r][c] == num) {
                        targetCol = c;
                        targetRow = r;
                    }
                    current++;
                }
            }
        }
        for(int r = targetRow; r<rows; r++) {
            if(arr[r][targetCol] != -1) {
                answer++;
            }
        }
        return answer;
    }
}
public class problem49 {
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;
        Solution sol = new Solution();
        System.out.println(sol.solution(n, w, num));
    }
}
