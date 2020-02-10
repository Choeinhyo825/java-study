package prob6;

public class Add extends Arith {

	public Add(int lValue, int rValue) {
		setA(lValue);
		setB(rValue);
	}

	@Override
	public int calculate() {
		return getA() + getB();
	}

}
