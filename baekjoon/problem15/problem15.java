package baekjoon.problem15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class problem15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int [] A = new int[1000000];
        int top = -1;
        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            switch(C) {
                case 1 :
                    int X = Integer.parseInt(st.nextToken());
                    A[++top] = X;
                    break;
                case 2 :
                    if(top < 0) {
                        bw.write(-1 + "\n");
                    }else {
                        bw.write(A[top--] + "\n");
                    }
                    break;
                case 3 :
                    bw.write(top+1 + "\n");
                    break;
                case 4 :
                    if(top < 0) {
                        bw.write(1 + "\n");
                    }else {
                        bw.write(0 + "\n");
                    }
                    break;
                case 5 :
                    if(top < 0) {
                        bw.write(-1 + "\n");
                    }else {
                        bw.write(A[top] + "\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}
