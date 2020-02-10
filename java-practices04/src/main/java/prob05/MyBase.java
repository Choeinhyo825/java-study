package prob05;

public class MyBase extends Base {

	@Override
	public void service(String state) {
		if ("오후".equals(state)) {
			afternoon();
			return;
		} else {
			super.service(state);
		}
	}

	private void afternoon() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}

	@Override
	public void day() {
		System.out.println("낮에는 열심히 일하자!");
	}

	@Override
	public void night() {
		System.out.println("night");
	}
}