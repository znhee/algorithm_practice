package implementation;

/**
 문제 달팽이2
 입력
	첫째 줄에 M과 N이 빈 칸을 사이에 두고 주어진다. (2 ≤ M, N ≤ 100)

 출력
	첫째 줄에 표의 모든 칸이 채워질 때까지 선이 꺾어지는 횟수를 출력한다.
 */
import java.io.*;
import java.util.*;

public class Main1952 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[M][N];
		
		int dy[] = {0, 1, 0, -1};
		int dx[] = {1, 0, -1, 0};
		int x = 0;
		int y = 0;
		visited[y][x] = true;
		int curvePoint = 0;
		int sum = 1;
		int idx = 0;
		while(true) {
			int nowY = y + dy[idx];
			int nowX = x + dx[idx];
			
			if(sum == N*M) {
				System.out.println(curvePoint); return;
			}
			if(nowX>=0 && nowX<N && nowY>=0 && nowY<M && !visited[nowY][nowX])  {
				sum++; 
				visited[nowY][nowX] = true;
				y = nowY;
				x = nowX;
			} else {
				idx++;
				curvePoint++;
			}
			
			idx %= 4;
		}
	}
}
