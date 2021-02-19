package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc21j4 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();
		int[] numbers = new int[input.length()];
		int swapCounter = 0;
		boolean changed;
		int temp;

		for (int i = 0; i < numbers.length; i++) {
			if (input.charAt(i) == 'S') {
				numbers[i] = 2;
			} else if (input.charAt(i) == 'M') {
				numbers[i] = 1;
			} else {
				numbers[i] = 0;
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			changed = false;
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
					changed = true;
					swapCounter++;
				}
			}
			if (!changed) {
				break;
			}
		}
		System.out.println(swapCounter);
	}
}
