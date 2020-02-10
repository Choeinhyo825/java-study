package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			int hap = 0;
			if(num % 2 ==0) {
				for(int i=0; i<=num;i++) {
					if(i%2 ==0) {
						hap = hap + i;
					}
				}
				System.out.println("결과값 : "+hap);
			}else {
				for(int i=0; i<=num;i++) {
					if(i%2 !=0) {
						hap = hap + i;
					}
				}
				System.out.println("결과값 : "+hap);
			}
			
		}
	}
}
