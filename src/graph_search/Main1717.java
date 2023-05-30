package graph_search;

/**
 문제
	초기에 n+1개의 집합 {0}, {1}, {2}, ... , {n}이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
	
	집합을 표현하는 프로그램을 작성하시오.

 입력
	첫째 줄에 n, m이 주어진다. m은 입력으로 주어지는 연산의 개수이다. 
	다음 m개의 줄에는 각각의 연산이 주어진다. 합집합은 0 a b의 형태로 입력이 주어진다. 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 
	두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.

 출력
	1로 시작하는 입력에 대해서 a와 b가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 */

import java.io.*;
import java.util.*;
public class Main1717 {
	
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		// 대표 노드를 자기 자신으로 초기화
		for(int i=0; i<=N; i++) {
			arr[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(q == 0) {
				union(a, b);
			} else {
				boolean result = checkSame(a,b);
				if(result) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b)
			arr[b] = a;
	}
	
	private static int find(int a) {
		if(a == arr[a]) return a;
		else return arr[a] = find(arr[a]);
	}
	
	private static boolean checkSame(int a, int b) {
		if(find(a) == find(b)) return true;
		return false;
	}
}
