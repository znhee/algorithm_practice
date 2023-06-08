package backtracking;

/**
 문제
	N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
	
	N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

 입력
	첫째 줄에 N이 주어진다. (1 ≤ N < 15)

 출력
	첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
*/
import java.io.*;

public class Main9663 {
	static int N, count;
	static int[] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];		// map[행] = 열
		visited = new boolean[N];
		count = 0;
		int row = 0;
		solve(row);
		System.out.print(count);
	}
	public static void solve(int row) {
		// 탈출 조건
		if(row==N) {
			count++;
			return;
		}
		for(int col=0; col<N; col++) {
			map[row] = col;
			// check=true 면 다음 행으로 
			// 퀸을 놓을 수 없으면 다음 열 값을 저장해서 확인
			if(row == 0 || check(row))
				solve(row+1);
		}
	}
	public static boolean check(int check) {
		for(int i=0; i<check; i++) {
			// map[i(행)]: 열값 == map[check(현재 행)]:열값 -> 이전 행과 현재 행의 열 값 비교
			// i-check(행 거리) == 열거리 -> 대각선 상에 존재한다
			// 퀸을 놓을 수 없다 : return false
			if(map[i] == map[check] || check - i == Math.abs(map[i] - map[check]))
				return false;
		}
		return true;
	}

}
