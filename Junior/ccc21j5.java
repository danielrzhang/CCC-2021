package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc21j5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String rOrC;
		int rOrCNumber;
		String[] paintInput;

		int rowCounter, columnCounter;
		rowCounter = 0;
		columnCounter = 0;

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		boolean[] rowData = new boolean[m];
		boolean[] columnData = new boolean[n];

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			paintInput =  br.readLine().split(" ");
			rOrC = paintInput[0];
			rOrCNumber = Integer.parseInt(paintInput[1]) - 1;

			if (rOrC.equals("R")) {
				if (!rowData[rOrCNumber]) {
					rowData[rOrCNumber] = true;
					columnCounter++;
				}

				else {
					rowData[rOrCNumber] = false;
					columnCounter--;
				}
			}

			else {
				if (!columnData[rOrCNumber]) {
					columnData[rOrCNumber] = true;
					rowCounter++;
				}

				else {
					columnData[rOrCNumber] = false;
					rowCounter--;
				}
			}
		}
		System.out.println((rowCounter * m) + (columnCounter * n) - (2 * rowCounter * columnCounter));
	}
}
