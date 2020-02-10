package prob6;

public class Mul extends Arith {

	public Mul(int lValue, int rValue) {
		setA(lValue);
		setB(rValue);
	}

	public int calculate() {
		return getA() * getB();
	}

}
