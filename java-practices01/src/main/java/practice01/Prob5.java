package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			String strCnt = String.valueOf(i);
			if (strCnt.contains("3") || strCnt.contains("6") || strCnt.contains("9")) {
				System.out.print(strCnt + " ");
				for (int j = 0; j < strCnt.length(); j++) {
					char chk = strCnt.charAt(j);
					if (chk == '3' || chk == '6' || chk == '9') {
						System.out.print("짝");
					}
				}
				System.out.println();
			}
		}
	}
}
