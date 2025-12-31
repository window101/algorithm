package baekjoon.problem17;

import java.io.IOException;
import java.util.Scanner;

public class problem17 {
    static int N;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }
    private static void backtracking(int row) {
        if(row == N) {
            cnt++;
            return;
        }
        for(int i = 0; i<N; i++) {
            arr[row] = i; // 각 행마다 queen이 1개 있어야 함
            if(check(row)) {
                backtracking(row+1);
            }
        }
    }
    private static boolean check(int row) {
        for(int i = 0; i<row; i++) {
            if(arr[i] == arr[row]) return false;
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) return false;
        }
        return true;
    }
}
