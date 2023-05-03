package baekjoon;

import java.io.*;

public class Main2839{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // N kg
        int cnt = 0;		// 봉지의 개수
        
        while(true) {
        	if (N%5 == 0) {		// 5kg 짜리로 최대한 나누기
            	cnt += N/5;
            	System.out.println(cnt);
            	break;
            } else {			// 3kg 짜리 하나씩 빼기 
            	N -= 3;
            	cnt ++;
            }
        	
        	if(N < 0) {
        		System.out.println("-1");
        		break;
        		
        	}
        }
    }
}