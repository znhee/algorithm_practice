package queue;

import java.util.*;
import java.io.*;

/** 소프티어 금고털이 문제 */
public class Main_금고털이 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());       // 배낭의 무게
        int N = Integer.parseInt(st.nextToken());       // 귀금속 종류

        PriorityQueue<Jewel> que = new PriorityQueue<Jewel>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            que.offer(new Jewel(weight, price));
        }
        
        int result = 0;

        while(!que.isEmpty()) {
            Jewel jewel = que.poll();
            if(jewel.weight > W) {
                result += W * jewel.price;
                break;
            } else {
                result += jewel.weight * jewel.price;
                W -= jewel.weight;
            }
        }
        System.out.print(result);
    }

    public static class Jewel implements Comparable<Jewel> {
        public int weight;
        public int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel jewel) {
            // price 값이 큰 순서대로 정렬
            return this.price < jewel.price ? 1 : -1;
        }
    }
}
