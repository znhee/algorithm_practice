package graph_search;

/**
 문제
	N×M크기의 배열로 표현되는 미로가 있다.
	
	1	0	1	1	1	1
	1	0	1	0	1	0
	1	0	1	0	1	1
	1	1	1	0	1	1
	미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
	이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
	한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
	
	위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

 입력
	첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

 출력
	첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 */

import java.io.*;
import java.util.*;

public class Main2178 {
	
	static int[][] graph;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(s.substring(j, j+1));
			}
		}
		visited[0][0] = true;
		bfs(0, 0);
		
		System.out.print(graph[N-1][M-1]);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
				if(!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
					que.offer(new int[] {nextX, nextY});
					graph[nextX][nextY] = graph[nowX][nowY] + 1;
					visited[nextX][nextY] = true;
				}
			}
		}
		
	}

}
