package prob6;

public class Div  extends Arith{

	public Div(int lValue, int rValue) {
		setA(lValue);
		setB(rValue);
	}

	public int calculate() {
		return getA() / getB();
	}

}
