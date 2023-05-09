package sorting;

/**
 문제
	배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

 입력
	첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

 출력
	첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다
*/
import java.io.*;
import java.util.Arrays;

public class Main1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] arr = new int[N.length()];
		for(int i=0; i<N.length(); i++) {
			arr[i] = Integer.parseInt(N.substring(i, i+1));
		}
		Arrays.sort(arr);
		for(int i=N.length()-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
		
//		// 선택 정렬
//		for(int i=0; i<N.length(); i++) {
//			int max = i;
//			for (int j=i+1; j<N.length(); j++) {
//				if(arr[j] > arr[max]) {
//					max = j;
//				}
//			}
//			if(arr[i] < arr[max]) {
//				int temp = arr[i];
//				arr[i] = arr[max];
//				arr[max] = temp;
//			}
//		}
//		
//		for(int i=0; i<N.length(); i++) {
//			System.out.print(arr[i]);
//		}
	}
}
