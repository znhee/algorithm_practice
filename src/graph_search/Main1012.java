package graph_search;

/**
 * 유기농 배추
 
 입력
	입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.  그 다음 줄부터 각각의 테스트 케이스에 대해
	첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
	그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
	그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.

 출력
	각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main1012 {
	static boolean[][] graph;
	static boolean[][] visited;
	static int M;
	static int N;
	static int dirY[] = {1, -1, 0, 0};
	static int dirX[] = {0, 0, 1, -1};
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(T-- > 0) {
			// 0. 입력 및 초기화
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());		// M: 가로길이
			N = Integer.parseInt(st.nextToken());		// N: 세로길이
			int K = Integer.parseInt(st.nextToken());		// K: 배추가 심어져 있는 위치의 개수
			
			graph = new boolean[60][60];
			visited = new boolean[60][60];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = true;		// 배추 좌표
			}
			
			int count = 0;		// 지렁이의 개수
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					// 전에 방문하지 않았고 배추가 있으면 dfs 실행
					if(!visited[i][j] && graph[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x + dirX[i];
			int newY = y + dirY[i];
			
			if(newX < 0 || newX >= M || newY < 0 || newY >= N) continue;
			// 상하좌우로 움직인 좌표에 방문 X && 배추가 있으면 dfs 실행
			if(!visited[newX][newY] && graph[newX][newY])
				dfs(newX, newY);
		}
	}

}
