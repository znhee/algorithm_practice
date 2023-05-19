package graph_search;

/** 
  문제 안전 영역(백준 2468)
  
  입력
	첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. N은 2 이상 100 이하의 정수이다. 
	둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다. 
	각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.

 출력
	첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다. 
 */
import java.io.*;
import java.util.*;

public class Main2468 {
	static int N, count, max;
	static int[][] rain;
	static boolean[][] visited;
	static ArrayList<Integer> safeRegion;
	static Queue<int[]> que;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rain = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				rain[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		// 아무 지역도 물에 안 잠길 수 있다 --> 높이 시작 0~100까지
		for(int i=0; i<=100; i++) {
			visited = new boolean[N][N];
			max = Math.max(max, bfs(i));
		}
		
		System.out.print(max);
		

	}

	private static int bfs(int n) {
		count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(rain[i][j] <= n || visited[i][j]) continue;
				
				que = new LinkedList<>();
				visited[i][j] = true;
				que.offer(new int[] {i, j});
				
				while(!que.isEmpty()) {
					int now[] = que.poll();
					int nowX = now[0];
					int nowY = now[1];
					
					for(int k=0; k<4; k++) {
						int nextX = nowX + dx[k];
						int nextY = nowY + dy[k];
						
						if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
						if(rain[nextX][nextY] <= n || visited[nextX][nextY]) continue;
						
						visited[nextX][nextY] = true;
						que.offer(new int[] {nextX, nextY});
					}
				}
				count++;
			}
		}
		return count;
		}
}
