package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV() {
	}

	public TV(int i, int j, boolean b) {
		this.channel = i;
		this.volume = j;
		this.power = b;
	}

	public void power(boolean b) {
		this.power = b;
	}

	public void channel(int i) {
		if (i < 1) {
			this.channel = 255;
		} else if (i > 255) {
			this.channel = 1;
		}else {
			this.channel =i;
		}
	}

	public void channel(boolean b) {
		if (b == true) {
			if (this.channel < 255) {
				this.channel += 1;
			} else {
				this.channel = 1;
			}
		} else {
			if (this.channel > 1) {
				this.channel -= 1;
			} else {
				this.channel = 255;
			}
		}

	}

	public void volume(int i) {
		this.volume = i;
	}

	public void volume(boolean b) {
		if (b == true) {
			if (this.volume < 255) {
				this.volume += 1;
			}
		} else {
			if (this.volume > 0) {
				this.volume -= 1;
			}
		}

	}

	public void status() {
		System.out.println("TV[channel=" + channel + "], volume=" + volume + ", power=" + power);
	}

}
