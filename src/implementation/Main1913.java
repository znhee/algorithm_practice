package implementation;

/**
 문제 달팽이
	홀수인 자연수 N이 주어지면, 다음과 같이 1부터 N2까지의 자연수를 달팽이 모양으로 N×N의 표에 채울 수 있다.
	
	9	2	3
	8	1	4
	7	6	5
	
	25	10	11	12	13
	24	9	2	3	14
	23	8	1	4	15
	22	7	6	5	16
	21	20	19	18	17
	
	N이 주어졌을 때, 이러한 표를 출력하는 프로그램을 작성하시오. 또한 N2 이하의 자연수가 하나 주어졌을 때, 그 좌표도 함께 출력하시오. 예를 들어 N=5인 경우 6의 좌표는 (4,3)이다.

 입력
	첫째 줄에 홀수인 자연수 N(3 ≤ N ≤ 999)이 주어진다. 둘째 줄에는 위치를 찾고자 하는 N2 이하의 자연수가 하나 주어진다.

 출력
	N개의 줄에 걸쳐 표를 출력한다. 각 줄에 N개의 자연수를 한 칸씩 띄어서 출력하면 되며, 자릿수를 맞출 필요가 없다. 
	N+1번째 줄에는 입력받은 자연수의 좌표를 나타내는 두 정수를 한 칸 띄어서 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main1913 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// N = 홀수인 자연수
		int M = Integer.parseInt(br.readLine());	// M = N2 이하의 자연수
		
		int[][] map = new int[N][N];
		int move = 1;
		int value = 1;
		int x = N/2;
		int y = N/2;
		map[y][x] = value;
		while(true) {
			for(int i=0; i<move; i++) {
				map[y--][x] = value++;
			}
			if(value == N*N+1) break;
			for(int i=0; i<move; i++) {
				map[y][x++] = value++;
			}
			move++;
			for(int i=0; i<move; i++) {
				map[y++][x] = value++;
			}
			for(int i=0; i<move; i++) {
				map[y][x--] = value++;
			}
			move++;
		}
		StringBuilder sb = new StringBuilder();
		int tx = 0;
		int ty = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
				if(M == map[i][j]) {
					ty = i+1;
					tx = j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(ty + " " + tx);
		System.out.println(sb.toString());
	}
}
