package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ccc21s1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Integer> widths = new ArrayList<Integer>();

		int n = Integer.parseInt(br.readLine());

		String[] stringHeight = br.readLine().split(" ");
		String[] stringWidth = br.readLine().split(" ");

		double totalArea = 0;

		for (int i = 0; i < stringHeight.length; i++) {
			heights.add(Integer.parseInt(stringHeight[i]));
		}

		for (int i = 0; i < stringWidth.length; i++) {
			widths.add(Integer.parseInt(stringWidth[i]));
		}

		for (int i = 0; i < n; i++) {
			totalArea += (heights.get(i) + heights.get(i + 1)) * widths.get(i) / 2.0;
		}

		System.out.println(totalArea);
	}
}
