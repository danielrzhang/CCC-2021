package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc21j1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int b = Integer.parseInt(in.readLine());
		int p = 5 * b - 400;
		System.out.println(p);

		if (p < b) System.out.println(1);
		else if (p > b) System.out.println(-1);
		else System.out.println(0);

	}

}
