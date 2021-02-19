package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc21s5 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] nwd = in.readLine().split(" ");
		int n = Integer.parseInt(nwd[0]);
		int w = Integer.parseInt(nwd[1]);
		int d = Integer.parseInt(nwd[2]);

		for (int i = 0; i < w; i++) {
			in.readLine().split(" ");
		}

		String[] stations;

		for (int i = 0; i < d; i++) {
			stations = in.readLine().split(" ");
		}
	}
}

