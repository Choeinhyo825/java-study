package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(">> ");
			String expr = sc.nextLine();
			if (expr.equals("quit")) {
				System.out.println("계산기 종료");
				break;
			}
			String[] tokens = expr.split(" ");

			if (tokens.length != 3) {
				System.out.println(">> 계산할 수 없는 연산식 입니다.");
				continue;
			}

			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result = 0;
			Arith a = null;
			
			if ("+".equals(tokens[1])) {
				 a = new Add(lValue, rValue);
				result = a.calculate();
			}
			if ("-".equals(tokens[1])) {
				a = new Sub(lValue, rValue);
				result = a.calculate();
			}
			if ("*".equals(tokens[1])) {
				a = new Mul(lValue, rValue);
				result = a.calculate();
			}
			if ("/".equals(tokens[1])) {
				a = new Div(lValue, rValue);
				result = a.calculate();
			}

			System.out.println(">> " + result);

		}

		sc.close();
	}

}
