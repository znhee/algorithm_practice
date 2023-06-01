package sorting;

/**
 문제
	수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
	
	Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
	
	X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 입력
	첫째 줄에 N이 주어진다.
	
	둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

 출력
	첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 */
import java.io.*;
import java.util.*;

public class Main18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sorted);
		HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
		int rank = 0;
		for(int i : sorted) {
			if(!rankMap.containsKey(i)) {
				rankMap.put(i, rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int key : arr) {
			int val = rankMap.get(key);
			sb.append(val + " ");
		}
		System.out.print(sb.toString());
	}

}
