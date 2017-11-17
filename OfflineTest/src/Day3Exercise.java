import javax.swing.LayoutStyle;

public class Day3Exercise {

	public char Exercise1(String input) {

		for (int i = 0; i < input.length(); i++) {
			char output = input.charAt(i);
			System.out.print(output);
			System.out.print(output);
		}
		return 0;
	}

	public String answeroneBest(String input) {
		String remp = "";

		for (int i = 0; i < input.length(); i++) {
			remp += input.charAt(i);
			remp += input.charAt(i);
		}
		return remp;
	}

	public String Exercise2(String input) {
		int firstbread = input.indexOf("bread");
		int endofbreadone = firstbread + 5;
		String inBread = input.substring(endofbreadone, input.length());

		String finalbread = input.substring(endofbreadone, inBread.length());

		return finalbread;

	}

	public boolean Exercise3(int small, int med, int large) {
		int differencea = small - med;
		int differenceeb = med - large;
		if (differencea == differenceeb)
			return true;
		else
			return false;

	}

	public String Exercise4(String input, int a) {
		String ending = input.substring(a, input.length() - a);
		return ending;
	}

	public boolean Exercise5(String input) {
		String ending = input.substring((input.length() - 2), input.length());
		if (ending.equals("ly")) {
			return true;
		}
		return false;

	}

	public String Exercise6(String input) {
		String temp = "";
		String lastvalue = input.substring(input.length() - 1, input.length());

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
			} else {
				temp += input.charAt(i);
			}
		}
		return temp + lastvalue;
	}

	public int Exercise7(int start) {
		if (start == 0) {
			return 0;
		}
		if (start == 1) {
			return 1;
		}

		return Exercise7(start - 2) + Exercise7(start - 1);
	}

	public int Exercise8(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		return 2 + Exercise8(bunnies - 1);
	}

	public String Exercise9() {
		String arg1 = "+";
		System.out.println(arg1);
		for (int i = 0; i < 10; i++) {
		}
		return "";
	}
}
