package graph_search;

/**
 문제
	방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

 입력
	첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
	둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

 출력
	첫째 줄에 연결 요소의 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main11724 {

	static boolean[] visited;
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		// N: 정점의 개수
		int M = Integer.parseInt(st.nextToken());		// M: 간선의 개수
		
		visited = new boolean[N+1];
		A = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 그래프 데이터 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());		// u: 시작 지점
			int v = Integer.parseInt(st.nextToken());		// v: 종료 지점
			A[u].add(v);
			A[v].add(u);
		}
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.print(count);
	}

	private static void DFS(int v) {
		if(visited[v]) return;
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i])
				DFS(i);
		}
	}

}
