package by.tc.task01.entity;

public class Oven extends Appliance{

	private int powerConsumption;
	private double weight;
	private int capacity;
	private double depth;
	private double height;
	private double width;

	public Oven() {

	}

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Oven oven = (Oven) o;

		if (powerConsumption != oven.powerConsumption) return false;
		if (Double.compare(oven.weight, weight) != 0) return false;
		if (capacity != oven.capacity) return false;
		if (Double.compare(oven.depth, depth) != 0) return false;
		if (Double.compare(oven.height, height) != 0) return false;
		return Double.compare(oven.width, width) == 0;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = powerConsumption;
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + capacity;
		temp = Double.doubleToLongBits(depth);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Oven{" +
			"powerConsumption=" + powerConsumption +
			", weight=" + weight +
			", capacity=" + capacity +
			", depth=" + depth +
			", height=" + height +
			", width=" + width +
			'}';
	}
}
