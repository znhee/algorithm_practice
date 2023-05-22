package graph_search;

/**
 문제
	루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

 입력
	첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

 출력
	첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 */

import java.io.*;
import java.util.*;

public class Main11725 {
	static int N;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<Integer>(); 
		}
		
		// 그래프 값 저장
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}

	}

	private static void dfs(int x) {
		if(visited[x]) return;
		visited[x] = true;
		for(int i: list[x]) {
			if(!visited[i]) {
				parent[i] = x;
				dfs(i);
			}
		}
	}

}
