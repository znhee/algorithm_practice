package graph_search;

/**
 문제 숨바꼭질
	수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
	만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
	
	수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

 입력
	첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

 출력
	수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
*/
import java.io.*;
import java.util.*;

public class Main1697 {
	
	static int N, K;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 수빈이의 위치
		K = Integer.parseInt(st.nextToken());	// 동생의 위치
		visited = new int[100001];
		visited[N] = 0;
		if(N==K) {
			System.out.print(0);
		} else {
			bfs(N);
		}
		
	}

	private static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		visited[x] = 1;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0; i<3; i++) {
				int next;
				if(i == 0) {
					next = now + 1;
				} else if(i == 1) {
					next = now - 1;
				} else {
					next = now * 2;
				}
				
				if(next == K) {
					System.out.print(visited[now]);
					return;
				}
				
				if(next < 0 || next > 100000) continue;
				if(visited[next] == 0) {
					que.offer(next);
					visited[next] = visited[now] + 1;
				}	
			}
		}
		
	}
}
