package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Random r = new Random();

		boolean re = true;
		do {
			int count = 1;
			int max = 100;
			int min = 1;
			int k = r.nextInt(100) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");
			int num = 0;
			do {
				System.out.println(min + " ~ " + max);
				System.out.print(count + ">>");
				num = sc.nextInt();
				if (k == num) {
					System.out.println("맞았습니다.");
					System.out.print("다시하시겠습니까?(y/n) >> ");
					boolean select = false;
					do {
						String answer = sc.next();
						if (answer.equals("y")) {
							re = true;
							select = false;
						} else if (answer.equals("n")) {
							re = select = false;
						} else {
							System.out.println("y/n 중에 선택하세요");
							select = true;
						}
					} while (select);
				} else if (k > num) {
					min = num;
					System.out.println("더 높게");
					count++;
				} else if (k < num) {
					max = num;
					System.out.println("더 낮게");
					count++;
				}
			} while (k != num);
		} while (re);
		System.out.println("종료되었습니다.");

		sc.close();
	}
}
