package Sorting;

import java.io.*;
import java.util.*;

/**
 문제
	N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

 입력
	첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

 출력
	첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/
public class Main2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// 방법 1 : Arrays.sort -> 시간초과 
//		int[] arr = new int[N];
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		Arrays.sort(arr);
		
//		for (int i=0; i<N; i++) {
//			System.out.println(arr[i]);
//		}
		
		// 방법 2 : Collections.sort
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);		// [1, 2, 3, 4, 5]
		
		for(Integer i: list) {
			// System.out.println(i); -> 시간초과남
			sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}

}
