package baekjoon.problem4;

import java.io.IOException;
import java.util.Scanner;

public class problem4 {
    static long A;
    static long B;
    static long C;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        System.out.println(POW(A, B) % C);
    }
    private static long POW(long a, long b) {
        if(b == 1) {
            return a%C;
        }
        long half = POW(a, b/2);
        long result = half * half % C;
        if(b %2 == 1) {
            result = result * a % C;
        }
        return result;
    }
}
