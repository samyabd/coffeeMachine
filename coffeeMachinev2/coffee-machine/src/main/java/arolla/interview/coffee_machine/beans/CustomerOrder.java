package arolla.interview.coffee_machine.beans;

import arolla.interview.coffee_machine.enums.DrinkEnum;

public class CustomerOrder {

	
	public CustomerOrder() {};
	public CustomerOrder(DrinkEnum drink, int nbSugar) {
		super();
		this.drink = drink;
		this.nbSugar = nbSugar;
	}

	private DrinkEnum drink;
	
	private int nbSugar;

	public DrinkEnum getDrink() {
		return drink;
	}

	public void setDrink(DrinkEnum drink) {
		this.drink = drink;
	}
	
	public int getNbSugar() {
		return nbSugar;
	}
	public void setNbSugar(int nbSugar) {
		this.nbSugar = nbSugar;
	}

	
	
}
