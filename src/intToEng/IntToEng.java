package intToEng;

import java.util.Scanner;

public class IntToEng {

	// メインメソッド
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		System.out.println(translateEng(input));

	}

	// 数値を英訳する変換するメソッド
	static String translateEng(int n) {
		String 十の位[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety" };
		String 一の位[] = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		String 十から十九[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		boolean andをつけなくてもいいか = false;
		String 英訳結果 = "";
		if (n >= 1000) {
			int t = n / 1000;
			if (t >= 100) {
				英訳結果 += 一の位[t / 100] + " hundred ";
				t %= 100;
				if(t>0) 英訳結果 += "and ";
			}
			if (t >= 20) {
				英訳結果 += 十の位[t/10];
				t %= 10;
				if(t>0) 英訳結果 += " ";
			}
			if (t >= 10) {
				英訳結果 += 十から十九[t % 10];
				t = 0;
			}
			if (t >= 2)
				英訳結果 += 一の位[t];
			英訳結果 += " thousand ";
			n %= 1000;
			andをつけなくてもいいか = true;
		}
		if (n >= 100) {
			英訳結果 += 一の位[n / 100] + " hundred ";
			n %= 100;
			andをつけなくてもいいか = false;
		}
		if (n >= 20) {
			英訳結果 += 十の位[n / 10];
			n = n % 10;
			if(n>0) 英訳結果 += " ";
			andをつけなくてもいいか = true;
		}
		if (n >= 10) {
			return 英訳結果 + 十から十九[n % 10];
		}
		if (n >= 0) {
			if (英訳結果.length() > 0 && n == 0)
				return 英訳結果;
			if (!andをつけなくてもいいか && 英訳結果.length() > 0) {
				英訳結果 += "and ";
			}
			英訳結果 += 一の位[n];
		}
		return 英訳結果;
	}
}