package baekjoon.problem20;

import java.io.*;
import java.util.*;

public class problem20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<N; i++) {
            set.add(br.readLine().trim());
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort((a,b) -> {
            if(a.length() != b.length()) return a.length()-b.length(); // 길이 오름차순
            return a.compareTo(b);
        });
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}