package arolla.interview.coffee_machine.bean;

import arolla.interview.coffee_machine.drinks.Drink;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.utility.Factory;

public class CustomerOrder {

	
	public CustomerOrder() {};
	public CustomerOrder(DrinkEnum drink, float givenMoney, Integer nbSugar) {
		super();
		
		this.drink = Factory.createDrink(drink, nbSugar);
		this.givenMoney = givenMoney;
	}

	private Drink drink;
	
	private float givenMoney;

	public Drink getDrink() {
		return drink;
	}

	public float getGivenMoney() {
		return givenMoney;
	}
	
	
	
}
