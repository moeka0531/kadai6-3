package intToEng;

import java.util.Scanner;

public class IntToEng {

	// ƒƒCƒ“ƒƒ\ƒbƒh
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		System.out.println(translateEng(input));

	}

	// ”’l‚ğ‰p–ó‚·‚é•ÏŠ·‚·‚éƒƒ\ƒbƒh
	static String translateEng(int n) {
		String \‚ÌˆÊ[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
					"seventy", "eighty", "ninety" };
		String ˆê‚ÌˆÊ[] = { "zero", "one", "two", "three", "four", "five", "six",
					"seven", "eight", "nine" };
		String \‚©‚ç\‹ã[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
					"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		boolean and‚ğ‚Â‚¯‚È‚­‚Ä‚à‚¢‚¢‚© = false;
		String ‰p–óŒ‹‰Ê = ""; 
		//’Ç‰Á•”•ª@100000‚©‚ç100099‚Ü‚Å‚ğ’Ç‰Á
		if( n >= 1000000){
			int t = n%10000;
			String s = "one million and ";
			if(t==0) ‰p–óŒ‹‰Ê = "one million";
			else if(t<10) ‰p–óŒ‹‰Ê = s + ˆê‚ÌˆÊ[t];
			else if(t<20) ‰p–óŒ‹‰Ê =s + \‚©‚ç\‹ã[t-10];
			else {
				int tmp = t/10;
				int tmp2 = t%10;
				‰p–óŒ‹‰Ê = s + \‚ÌˆÊ[tmp] + " " + ˆê‚ÌˆÊ[tmp2];
			}
			return ‰p–óŒ‹‰Ê;
		}
		if (n >= 1000) {
			int t = n / 1000;
			if (t >= 100) {
				‰p–óŒ‹‰Ê += ˆê‚ÌˆÊ[t / 100] + " hundred ";
				t %= 100;
				if(t>0) ‰p–óŒ‹‰Ê += "and ";
			}
			if (t >= 20) {
				‰p–óŒ‹‰Ê += \‚ÌˆÊ[t/10];
				t %= 10;
				if(t>0) ‰p–óŒ‹‰Ê += " ";
			}
			if (t >= 10) {
				‰p–óŒ‹‰Ê += \‚©‚ç\‹ã[t % 10];
				t = 0;
			}
			if (t >= 2) ‰p–óŒ‹‰Ê += ˆê‚ÌˆÊ[t];
				‰p–óŒ‹‰Ê += " thousand ";
				n %= 1000;
				and‚ğ‚Â‚¯‚È‚­‚Ä‚à‚¢‚¢‚© = true;
			}
			if (n >= 100) {
				‰p–óŒ‹‰Ê += ˆê‚ÌˆÊ[n / 100] + " hundred ";
				n %= 100;
				and‚ğ‚Â‚¯‚È‚­‚Ä‚à‚¢‚¢‚© = false;
			}
			if (n >= 20) {
				‰p–óŒ‹‰Ê += \‚ÌˆÊ[n / 10];
				n = n % 10;
				if(n>0) ‰p–óŒ‹‰Ê += " ";
				and‚ğ‚Â‚¯‚È‚­‚Ä‚à‚¢‚¢‚© = true;
			}
			if (n >= 10) {
				return ‰p–óŒ‹‰Ê + \‚©‚ç\‹ã[n % 10];
			}
			if (n >= 0) {
				if (‰p–óŒ‹‰Ê.length() > 0 && n == 0)
				return ‰p–óŒ‹‰Ê;
			if (!and‚ğ‚Â‚¯‚È‚­‚Ä‚à‚¢‚¢‚© && ‰p–óŒ‹‰Ê.length() > 0) {
				‰p–óŒ‹‰Ê += "and ";
			}
			‰p–óŒ‹‰Ê += ˆê‚ÌˆÊ[n];
		}
		return ‰p–óŒ‹‰Ê;
	}
}