package intToEng;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class IntToEngTest {

	@Test
	public void テスト1回目_0から20まで() {
		IntToEng ite = new IntToEng();
		String s[] = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen", "twenty" };
		for (int i = 0; i <= 5; i++) {
			String t = ite.translateEng(i);
			String expected = s[i];
			assertThat(t, is(expected));
		}
	}

	@Test
	public void テスト2回目_100まで() {
		IntToEng ite = new IntToEng();
		String expected = "";
		String act = "";
		String s1[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety" };
		String s2[] = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };

		for (int i = 2; i < s1.length; i++) {
			for (int k = 0; k < s2.length; k++) {
				expected = s1[i];
				if (k > 0)
					expected += " "+s2[k];
				act = ite.translateEng(i * 10 + k);
				assertThat(act, is(expected));
			}
		}
		expected = "one hundred ";
		act = ite.translateEng(100);
		assertThat(act, is(expected));
	}

	@Test
	public void テスト3回目_999まで() {
		IntToEng ite = new IntToEng();
		String expected = "";
		int num = 0;
		String act = "";
		String s1[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety" };
		String s2[] = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		String s3[] = { "", "ten", "eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		for (int i = 0; i <= 9; i++) { // 100の位
			for (int k = 0; k <= 9; k++) { // 10の位
				for (int l = 0; l <= 9; l++) { // 1の位
					expected = "";

					if (i > 0)
						expected += s2[i] + " hundred ";

					if (k >= 2){
						expected += s1[k];
						if(l>0) expected += " ";
					}

					if (k * 10 + l < 20 && k * 10 + l >= 10) {
						expected += s3[l + 1];
					} else {
						if (expected.length() > 0 && l == 0)
							;
						else if (i > 0 && k == 0)
							expected += "and " + s2[l];
						else
							expected += s2[l];
					}
					num = i * 100 + k * 10 + l;
					// System.out.println(i+" "+k+" "+l+"   "+num);
					act = ite.translateEng(num);
					assertThat(act, is(expected));

				}
			}
		}
	}

	@Test
	public void テスト4回目_9999まで() {
		IntToEng ite = new IntToEng();
		String expected = "";
		int num = 0;
		String act = "";

		String s1[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety" };
		String s2[] = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		String s3[] = { "", "ten", "eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		for (int h = 0; h <= 9; h++)
			// 1000の位
			for (int i = 0; i <= 9; i++)
				// 100の位
				for (int k = 0; k <= 9; k++)
					// 10の位
					for (int l = 0; l <= 9; l++) { // 1の位
						expected = "";
						if (h > 0) {
							if (h >= 2)
								expected += s2[h];
							expected += " thousand ";
						}
						if (i > 0)
							expected += s2[i] + " hundred ";

						if (k >= 2){
							expected += s1[k];
							if(l>0) expected += " ";
						}

						if (k * 10 + l < 20 && k * 10 + l >= 10) {
							expected += s3[l + 1];
						} else {
							if (expected.length() > 0 && l == 0)
								;
							else if (i > 0 && k == 0)
								expected += "and " + s2[l];
							else
								expected += s2[l];
						}
						num = h * 1000 + i * 100 + k * 10 + l;
						// System.out.println(h+" "+i+" "+k+" "+l+"   "+num);
						act = ite.translateEng(num);
						assertThat(act, is(expected));

					}
	}

	@Test
	public void テストおまけ_一万以上を適当に() {
		IntToEng ite = new IntToEng();
		
		String t = ite.translateEng(992301);
		String expected = "nine hundred and ninety two thousand three hundred and one";
		assertThat(t, is(expected));
		
	}

}