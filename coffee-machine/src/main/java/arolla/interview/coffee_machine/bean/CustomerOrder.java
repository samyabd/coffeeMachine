package arolla.interview.coffee_machine.bean;

import arolla.interview.coffee_machine.drinks.Drink;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.utility.Factory;

public class CustomerOrder {

	
	public CustomerOrder() {};
	public CustomerOrder(DrinkEnum drink, Short nbSugar, float givenMoney) {
		super();
		
		this.drink = Factory.createDrink(drink);
		this.nbSugar = nbSugar;
		this.givenMoney = givenMoney;
	}

	private Drink drink;
	
	private Short nbSugar;
	
	private float givenMoney;

	public Drink getDrink() {
		return drink;
	}

	public Short getNbSugar() {
		return nbSugar;
	}
	
	public float getGivenMoney() {
		return givenMoney;
	}
	
	
	
}
