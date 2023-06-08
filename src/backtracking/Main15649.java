package backtracking;

/**
 문제
	자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	
	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 입력
	첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

 출력
	한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

	수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
import java.io.*;
import java.util.*;

public class Main15649 {
	static int N, M;
	static int[] arr, result;
	static HashSet<String> set;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		result = new int[M];
		set = new HashSet<String>();
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		solve(0);
		
		ArrayList<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	private static void solve(int num) {
		if(num == M) {
			String s = "";
			for(int i=0; i<result.length; i++) {
				s += result[i] + " ";
			}
			set.add(s);
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[num] = arr[i];
				solve(num+1);
				visited[i] = false;
			}
		}
	}

}
