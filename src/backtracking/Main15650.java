package backtracking;

/**
 문제
	자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	
	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	고른 수열은 오름차순이어야 한다.
 입력
	첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

 출력
	한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

	수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
import java.io.*;
import java.util.*;

public class Main15650 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		solve(1, 0);
		
		System.out.print(sb.toString());
	}
	private static void solve(int start, int depth) {
		if(depth == M) {
			for(int val:arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=N; i++) {
			arr[depth] = i;
			solve(i+1, depth+1);

		}		
	}

}
