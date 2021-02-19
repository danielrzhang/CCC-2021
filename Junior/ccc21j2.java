package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc21j2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		String winnerName = "";
		int winnerNum = 0;

		String name;
		int bid;
		for (int i = 0; i < n; i++) {
			name = in.readLine();
			bid = Integer.parseInt(in.readLine());

			if (bid > winnerNum) {
				winnerNum = bid;
				winnerName = name;
			}
		}
		System.out.println(winnerName);
	}
}
