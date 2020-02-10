package prob6;

public class Sub extends Arith {

	public Sub(int lValue, int rValue) {
		setA(lValue);
		setB(rValue);
	}

	public int calculate() {
		return getA() - getB();
	}

}
