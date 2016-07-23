package pizza;

public abstract class Pizza {
	protected String type;
	protected boolean dressing;
	protected double weight;
	
	public Pizza() {
		generatePizza();
	}
	
	public abstract void generatePizza() ;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isDressing() {
		return dressing;
	}
	public void setDressing(boolean dressing) {
		this.dressing = dressing;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
