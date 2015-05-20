package intToEng;

import java.util.Scanner;

public class IntToEng {

	// ���C�����\�b�h
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		System.out.println(translateEng(input));

	}

	// ���l���p�󂷂�ϊ����郁�\�b�h
	static String translateEng(int n) {
		String �\�̈�[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
					"seventy", "eighty", "ninety" };
		String ��̈�[] = { "zero", "one", "two", "three", "four", "five", "six",
					"seven", "eight", "nine" };
		String �\����\��[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
					"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		boolean and�����Ȃ��Ă������� = false;
		String �p�󌋉� = ""; 
		//�ǉ������@100000����100099�܂ł�ǉ�
		if( n >= 1000000){
			int t = n%10000;
			String s = "one million and ";
			if(t==0) �p�󌋉� = "one million";
			else if(t<10) �p�󌋉� = s + ��̈�[t];
			else if(t<20) �p�󌋉� =s + �\����\��[t-10];
			else {
				int tmp = t/10;
				int tmp2 = t%10;
				�p�󌋉� = s + �\�̈�[tmp] + " " + ��̈�[tmp2];
			}
			return �p�󌋉�;
		}
		if (n >= 1000) {
			int t = n / 1000;
			if (t >= 100) {
				�p�󌋉� += ��̈�[t / 100] + " hundred ";
				t %= 100;
				if(t>0) �p�󌋉� += "and ";
			}
			if (t >= 20) {
				�p�󌋉� += �\�̈�[t/10];
				t %= 10;
				if(t>0) �p�󌋉� += " ";
			}
			if (t >= 10) {
				�p�󌋉� += �\����\��[t % 10];
				t = 0;
			}
			if (t >= 2) �p�󌋉� += ��̈�[t];
				�p�󌋉� += " thousand ";
				n %= 1000;
				and�����Ȃ��Ă������� = true;
			}
			if (n >= 100) {
				�p�󌋉� += ��̈�[n / 100] + " hundred ";
				n %= 100;
				and�����Ȃ��Ă������� = false;
			}
			if (n >= 20) {
				�p�󌋉� += �\�̈�[n / 10];
				n = n % 10;
				if(n>0) �p�󌋉� += " ";
				and�����Ȃ��Ă������� = true;
			}
			if (n >= 10) {
				return �p�󌋉� + �\����\��[n % 10];
			}
			if (n >= 0) {
				if (�p�󌋉�.length() > 0 && n == 0)
				return �p�󌋉�;
			if (!and�����Ȃ��Ă������� && �p�󌋉�.length() > 0) {
				�p�󌋉� += "and ";
			}
			�p�󌋉� += ��̈�[n];
		}
		return �p�󌋉�;
	}
}