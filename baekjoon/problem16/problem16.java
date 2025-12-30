package baekjoon.problem16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i<N; i++) {
            Stack<Character> stack = new Stack<>();
            char[] str = br.readLine().toCharArray();
            stack.push(str[0]);
            for(int j = 1; j<str.length; j++) {
                if(!stack.isEmpty() && stack.peek().equals(str[j])) {
                    stack.pop();
                }else {
                    stack.push(str[j]);
                }
            }
            if(stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
