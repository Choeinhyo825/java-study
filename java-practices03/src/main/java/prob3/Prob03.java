package prob3;

public class Prob03 {

	public static void main(String[] args) {
		CurrencyConverter.setRate( 1118.70 );
		
		double dollar = CurrencyConverter.toDollar( 1000000 );
		System.out.println( "백만원은 " + dollar + "달러입니다." );
		
		double krw = CurrencyConverter.toKRW( 100 );
		System.out.println( "백달러는 " + krw + "원 입니다." );		
	}
}
//백만원은 860.0달러입니다.
//백달러는 116279.06976744186원 입니다.

//백만원은 893.8946992044337달러입니다.
//백달러는 111870.0원 입니다.
