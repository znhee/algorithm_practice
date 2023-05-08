package graph_search;

/**
 문제
	그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
	단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

 입력
	첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
	다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

 출력
	첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
*/
import java.io.*;
import java.util.*;

public class Main1260 {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] graph;
	static boolean[] check;
	
	static int node, line, start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());	//	N: 정점의 개수
		line = Integer.parseInt(st.nextToken());	//	M: 간선의 개수
		start = Integer.parseInt(st.nextToken());	//	V: 탐색 시작 번호
		
		graph = new int[node+1][node+1];
		check = new boolean[node+1];
		
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int	a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		dfs(start);
		sb.append("\n");
		
		check = new boolean[node+1];
		bfs(start);
		System.out.print(sb.toString());
		
	}
	
	static void dfs(int start) {
		check[start] = true;
		sb.append(start).append(" ");
		
		for(int i=1; i<=node; i++) {
			if(!check[i] && graph[start][i]== 1)	// 방문하지 않았거나, 간선이 있는 경우
				dfs(i);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> myQue = new LinkedList<Integer>();
		myQue.offer(start);
		check[start] = true;
		
		while(!myQue.isEmpty()) {
			int curr = myQue.poll();
			sb.append(curr).append(" ");
			
			for(int i=1; i<=node; i++) {
				if(!check[i] && graph[curr][i]==1) {	// 방문하지 않았거나, 간선이 있는 경우
					myQue.offer(i);
					check[i] = true;
				}
			}
		}
		
	}
}
