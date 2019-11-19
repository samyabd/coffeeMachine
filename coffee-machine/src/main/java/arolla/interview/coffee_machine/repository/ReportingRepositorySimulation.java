package arolla.interview.coffee_machine.repository;

public class ReportingRepositorySimulation {

	private int coffeeSold=0;
	private int teaSold=0;
	private int chocolateSold=0;
	private int orangeJuiceSold=0;
	private float totalSold=0;
	public int getCoffeeSold() {
		return coffeeSold;
	}
	public void setCoffeeSold(int coffeeSold) {
		this.coffeeSold = coffeeSold;
	}
	public int getTeaSold() {
		return teaSold;
	}
	public void setTeaSold(int teaSold) {
		this.teaSold = teaSold;
	}
	public int getChocolateSold() {
		return chocolateSold;
	}
	public void setChocolateSold(int chocolateSold) {
		this.chocolateSold = chocolateSold;
	}
	public int getOrangeJuiceSold() {
		return orangeJuiceSold;
	}
	public void setOrangeJuiceSold(int orangeJuiceSold) {
		this.orangeJuiceSold = orangeJuiceSold;
	}
	public float getTotalSold() {
		return totalSold;
	}
	public void setTotalSold(float totalSold) {
		this.totalSold = totalSold;
	}
	
	public String toString()
	{
		return  "Coffee: "+this.coffeeSold+" sold, Chocolat "+this.chocolateSold+" sold, Tea "+this.teaSold+" sold, Orange Juice "+this.orangeJuiceSold+" sold, total sold: "+this.totalSold+"e";

	}
	
}
