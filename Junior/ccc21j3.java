package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc21j3 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();

		int firstNum;
		int secondNum;
		String secondPart;
		String previousInstruction = "";

		while (!input.equals("99999")) {
			firstNum = Integer.parseInt(input.substring(0, 1));
			secondNum = Integer.parseInt(input.substring(1, 2));
			secondPart = input.substring(2);

			if (firstNum + secondNum == 0) {
				System.out.println(previousInstruction + secondPart);
			} else if ((firstNum + secondNum) % 2 == 0) {
				previousInstruction = "right ";
				System.out.println(previousInstruction + secondPart);
			} else {
				previousInstruction = "left ";
				System.out.println(previousInstruction + secondPart);
			}
			input = in.readLine();
		}
	}
}
