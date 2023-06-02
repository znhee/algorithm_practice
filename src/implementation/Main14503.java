package implementation;

/**
 문제 
	 로봇 청소기는 다음과 같이 작동한다.
	
	1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
	2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우, 
		1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
		2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
	3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
		1. 반시계 방향으로 90도 회전한다.
		2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
		3. 1번으로 돌아간다.
 입력
	첫째 줄에 방의 크기 N과 M이 입력된다. (3<= N, M <= 50) 둘째 줄에 처음에 로봇청소기가 있는 칸의 좌표(r,c)와 처음에 로봇청소기가 바라보는 방향 d가 입력된다. 
	d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽을 바라보고 있는 것이다.
	
	셋째 줄부터 N개의 줄에 각 장소의 상태를 나타내는 N * M개의 값이 한 줄에 M개씩 입력된다. 
	i번째 줄의 j번째 값은 칸 (i, j)의 상태를 나타내며, 이 값이 0인 경우 (i, j)가 청소되지 않은 빈 칸이고, 1인 경우 (i, j)에 벽이 있는 것이다. 
	방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽이 있다. 로봇 청소기가 있는 칸은 항상 빈 칸이다.

 출력
	로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수를 출력한다.
 */
import java.io.*;
import java.util.*;

public class Main14503 {
	static int cleaned[][];
	static int N, M, count;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int y=0, x=0, d=0;
		cleaned = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				cleaned[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 1;
		dfs(y, x, d);
		
		System.out.print(count);
		
	}

	private static void dfs(int y, int x, int d) {
		cleaned[y][x] = -1;
		
		for(int i=0; i<4; i++) {
			d = (d+3) % 4;		// 반시계 방향으로 회전
			int nowY = y + dy[d];
			int nowX = x + dx[d];
			
			if(nowY>=0 && nowY<N && nowX>=0 && nowX<M && cleaned[nowY][nowX] == 0) {
				count++;
				dfs(nowY, nowX, d);
				return;
			}
		}
		int backDir = (d+2) % 4;	// 바라보는 방향으로 후진
		int backY = y + dy[backDir];
		int backX = x + dx[backDir];
		
		if(backY>=0 && backY<N && backX>=0 && backX<M && cleaned[backY][backX] != 1) {
			dfs(backY, backX, d);
		}
		
	}

}
