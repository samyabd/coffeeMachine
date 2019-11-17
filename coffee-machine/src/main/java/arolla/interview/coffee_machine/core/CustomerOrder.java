package arolla.interview.coffee_machine.core;

import arolla.interview.coffee_machine.enums.DrinkEnum;

public class CustomerOrder {

	
	public CustomerOrder() {};
	public CustomerOrder(DrinkEnum drink, Short nbSugar, String message) {
		super();
		this.drink = drink;
		this.nbSugar = nbSugar;
		this.message = message;
	}

	private DrinkEnum drink;
	
	private Short nbSugar;
	
	private String message;

	public DrinkEnum getDrink() {
		return drink;
	}

	public void setDrink(DrinkEnum drink) {
		this.drink = drink;
	}

	

	public Short getNbSugar() {
		return nbSugar;
	}
	public void setNbSugar(Short nbSugar) {
		this.nbSugar = nbSugar;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
