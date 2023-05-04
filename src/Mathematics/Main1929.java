package Mathematics;

import java.io.*;
import java.util.*;

/**
 문제
	M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

 입력
	첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

 출력
	한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.*/

public class Main1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		primeNumber(M, N);
		
		// 방법 1 -> 시간 초과
//		for(int i=M; i<=N; i++) {
//			for(int j=2; j<=i; j++) {
//				if(i % j == 0) {
//					if(i == j) {
//						sb.append(i).append("\n");
//					} else {
//						break;
//					}
//				}
//			}
//		}
//		System.out.print(sb.toString());

	}
	
	// 방법 2 - 에라토스테네스의 체
	static void primeNumber(int M, int N) {
		boolean[] arr = new boolean[N+1];
		arr[0] = arr[1] = true; // 0과 1은 소수 아님
		
		// 2부터 시작해서 i의 배수들을 배열에서 지워줌
		for(int i=2; i<=(int)Math.sqrt(N); i++) {
			for(int j=i+i; j<=N; j+=i) {
				arr[j] = true;
			}
		}
		for(int i=M; i<=N; i++) {
			if(arr[i] == false)
				System.out.println(i);
		}
	}
}
