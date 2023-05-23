package greedy;

/**
 문제
 	백준 13305 주유소
 	각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
 입력
	표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다. 
	다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다. 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다. 
	제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 

 출력
	표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다. 
 */

import java.io.*;
import java.util.*;

public class Main13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 도시의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] road = new long[N];

		for(int i=0; i<N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		long[] city = new long[N];
		for(int i=0; i<N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		long cost = 0;
		long min = city[0];
		
		for(int i=0; i<N-1; i++) {
			if(city[i] < min) {
				min = city[i];
			}
			cost += (min * road[i]);
		}
		
		System.out.print(cost);
	}
}
