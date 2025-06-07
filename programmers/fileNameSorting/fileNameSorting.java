package programmers.fileNameSorting;

import java.util.Arrays;

class Solution {

    static class FileSort {
        public int indx;
        public String number = "";
        public int realNum;
        public String head = "";
        public String tail = "";
        public String str;
        FileSort(String str, int indx) {
            this.str = str;
            this.indx = indx;
            parse();
        }
        public void parse() {
            
            char [] arr = str.toLowerCase().toCharArray();
            int i = 0;
            while(i < arr.length && !Character.isDigit(arr[i])) {
                head += arr[i];
                i++;
            }
            while(i < arr.length && Character.isDigit(arr[i]) && number.length() <= 5) {
                number += arr[i];
                i++;
            }
            while(i < arr.length) {
                tail += arr[i];
                i++;
            }
            realNum = Integer.parseInt(number);
        }
    }
    public String[] solution(String[] files) throws Exception{
        
        FileSort[] filesort = new FileSort[files.length];
        for(int i = 0; i<files.length; i++) {
            filesort[i] = new FileSort(files[i], i);
        }
        Arrays.sort(filesort, (a,b) -> { // 사용자 기준 정렬 (head 사전순 -> realNum 숫자 크기순)
            int headComp = a.head.compareTo(b.head);
            if(headComp != 0) return headComp;
            int numComp = Integer.compare(a.realNum, b.realNum);
            return numComp;
        });
        String[] answer = new String[files.length];
        for(int i = 0; i<files.length; i++) {
            answer[i] = filesort[i].str;
        }
        return answer;
    }
}
public class fileNameSorting {
    public static void main(String[] args) throws Exception {
        String [] files = new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(files)));
    }
}
