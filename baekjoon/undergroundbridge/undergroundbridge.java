package baekjoon.undergroundbridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class undergroundbridge {
    static int N;
    static int M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void binarySearch() {
        int left = 0;
        int right = N;
        int mid = 0;
        
        while(left <= right) {
            boolean check = true;
            mid = (left + right) / 2;
            if(arr[0] - mid > 0) {
                check = false;
            }
            if(arr[M-1] + mid < N) {
                check = false;
            }
            for(int i = 0; i<M-1; i++) {
                if(arr[i] + mid < arr[i+1] - mid) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer = Math.min(answer, mid);
                right = mid - 1;
                
            }else {
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[M];
        for(int i = 0; i<M; i++) {
            if(st.hasMoreTokens()) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
        binarySearch();
    }
}
