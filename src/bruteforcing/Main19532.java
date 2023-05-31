package bruteforcing;

/**
 백준 19532 : 수학은 비대면강의입니다
 */
import java.io.*;

public class Main19532 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		int d = Integer.parseInt(str[3]);
		int e = Integer.parseInt(str[4]);
		int f = Integer.parseInt(str[5]);
		
		for(int x=-999; x<=999; x++) {
			for (int y=-999; y<=999; y++) {
				if((a*x + b*y == c) && (d*x + e*y == f))
					sb.append(x + " " + y);
			}
		}
		System.out.print(sb);
		
	}

}
