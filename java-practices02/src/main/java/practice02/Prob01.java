package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");

		int num = scanner.nextInt();
		int m1 = num/MONEYS[0];
		int n1 = num%MONEYS[0];
		
		int m2 = n1/MONEYS[1];
		int n2 = n1%MONEYS[1];
		
		int m3 = n2/MONEYS[2];
		int n3 = n2%MONEYS[2];

		int m4 = n3/MONEYS[3];
		int n4 = n3%MONEYS[3];
		
		int m5 = n4/MONEYS[4];
		int n5 = n4%MONEYS[4];
		
		int m6 = n5/MONEYS[5];
		int n6 = n5%MONEYS[5];
		
		int m7 = n6/MONEYS[6];
		int n7 = n6%MONEYS[6];
		
		int m8 = n7/MONEYS[7];
		int n8 = n7%MONEYS[7];
		
		int m9 = n8/MONEYS[8];
		int n9 = n8%MONEYS[8];
		
		int m10 = n9/MONEYS[9];
		
		System.out.println("50000원 : " + m1 +"개");
		System.out.println("10000원 : " + m2 +"개");
		System.out.println("5000원 : " + m3 +"개");
		System.out.println("1000원 : " + m4 +"개");
		System.out.println("500원 : " + m5 +"개");
		System.out.println("100원 : " + m6 +"개");
		System.out.println("50원 : " + m7 +"개");
		System.out.println("10원 : " + m8 +"개");
		System.out.println("5원 : " + m9 +"개");
		System.out.println("1원 : " + m10 +"개");
		
		scanner.close();
	}

}
