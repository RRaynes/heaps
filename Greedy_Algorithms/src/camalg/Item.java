package camalg;

public class Item {
	int ID;
	double weight;
	double value;
	double factor;
	
	public Item(int ID, double weight, double value) {
		this.ID = ID;
		this.weight = weight;
		this.value = value;
	}
	
	/**
	 * first way we define the factor, in this case the factor is determined by the value
	 */
	void factorByValue() {
		factor = value;
	}
	
	/**
	 * first way we define the factor, in this case the factor is determined by the value to weight ratio
	 */
	void factorByLightest() {
		factor = Math.pow(weight, -1);
	}
	
	/**
	 * first way we define the factor, in this case the factor is determined by the value to weight ratio
	 */
	void factorByVWRatio() {
		factor = value/weight;
	}
}