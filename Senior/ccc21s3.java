package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ccc21s3 {

	static ArrayList<Walker> listOfPeople = new ArrayList<Walker>();
	static int n;

	public static long f(int p) {
		int combinedTime = 0;
		int musicRange = 0;

		for (int j = 0; j < n; j++) {
			if (Math.abs(listOfPeople.get(j).position - p) > listOfPeople.get(j).range) {
				musicRange = Math.abs(listOfPeople.get(j).position - p) - listOfPeople.get(j).range;
			} else {
				musicRange = 0;
			}
			combinedTime += musicRange * listOfPeople.get(j).speed;
		}
		return combinedTime;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Long> timeList = new ArrayList<Long>();
		String[] input;

		long combinedTime;
		int musicRange;

		n = Integer.parseInt(br.readLine());
		int maxPos = 0;
		int averagePos = 0;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			listOfPeople.add(new Walker(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
			averagePos += Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
		}

		Collections.sort(listOfPeople);
		averagePos /= listOfPeople.size();

		//for (int i = 0; i <= maxPos; i++) {
		int middle = (listOfPeople.get(n - 1).position - listOfPeople.get(0).position) / 2;
		int a = middle;
		int b = middle;

		long first = f(a);
		long second = first;

		long tempLong;
		do {
			a++;
			tempLong = f(a);
			if (tempLong < first) {
				first = tempLong;
			} else {
				break;
			}
		} while(a < listOfPeople.size() - 1);

		do {
			b--;
			tempLong = f(b);
			if (tempLong < second) {
				second = tempLong;
			} else {
				break;
			}
		} while(b > 0);

		long min = Math.min(first, second);
		System.out.println(min);
		//			combinedTime = 0;
		//			for (int j = 0; j < n; j++) {
		//				if (Math.abs(listOfPeople.get(j).position - i) > listOfPeople.get(j).range) {
		//					musicRange = Math.abs(listOfPeople.get(j).position - i) - listOfPeople.get(j).range;
		//				} else {
		//					musicRange = 0;
		//				}
		//				combinedTime += musicRange * listOfPeople.get(j).speed;
		//			}
		//			timeList.add(combinedTime);
		//System.out.println(Collections.min(timeList));
	}
}

class Walker implements Comparable<Walker> {
	int position;
	int speed;
	int range;

	public Walker(int position, int speed, int range) {
		this.position = position;
		this.speed = speed;
		this.range = range;
	}

	public int compareTo(Walker walker) {
		if (walker.position < this.position) {
			return 1;
		}

		else if (walker.position > this.position) {
			return -1;
		}

		else {
			return 0;
		}
	}
}