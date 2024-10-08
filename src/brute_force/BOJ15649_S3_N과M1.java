package brute_force;

import java.io.*;
import java.util.*;

public class BOJ15649_S3_N과M1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,m;
	static int [] arr = new int[10];
	static boolean [] isUsed = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		n = Integer.parseInt(str.split(" ")[0]);
		m = Integer.parseInt(str.split(" ")[1]);

		recursion(0);
	}
	
	static void recursion (int depth) {
		if(depth == m) {
			sb.setLength(0);
			for(int i=0;i<m;i++)
				sb.append(arr[i]).append(" ");
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!isUsed[i]) {
				arr[depth] = i;
				isUsed[i] = true;
				recursion(depth+1);
				isUsed[i] = false;				
			}
		}
	}

}
