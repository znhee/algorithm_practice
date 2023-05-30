package graph_search;
/**
 문제
	그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

	그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

 입력
	입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 
	각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다. 

 출력
	K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
 */

import java.io.*;
import java.util.*;

public class Main1707 {
	static int node, line;
	static int[] check;
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean IsEven;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			A = new ArrayList[node+1];
			visited = new boolean[node+1];
			check = new int[node+1];
			IsEven = true;
			// ArrayList 초기화
			for(int i=1; i<=node; i++) {
				A[i] = new ArrayList<Integer>();
			}
			// 에지 데이터 저장
			for(int i=0; i<line; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				A[start].add(end);
				A[end].add(start);
			}
			// 각 노드에서 dfs 실행
			for(int i=1; i<=node; i++) {
				if(IsEven) dfs(i);
				else break;
			}
			
			// 이분 그래프 여부 출력
			if(IsEven) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	// dfs 구현
	private static void dfs(int start) {
		visited[start] = true;
		// 인접리스트로 받아서 start에 연결된 모든 노드 탐색 가능
		for(int i: A[start]) {
			if(!visited[i]) {
				check[i] = (check[start] + 1) % 2;
				dfs(i);
			} else {
				if(check[start] == check[i])
					IsEven = false;
			}
		}
		
	}
}
