package model.entity;

public class Range {
	private int min;
	private int max;
	private double per;

	public Range(int min, int max, double per) {
		this.min = min;
		this.max = max;
		this.per = per;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}

}
