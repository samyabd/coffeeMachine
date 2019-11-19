package arolla.interview.coffee_machine.logic;

import arolla.interview.coffee_machine.drinks.Drink;

/**
 * The interface that defines functionnal controles on orders
 * @author samya
 *
 */
public interface ICoffeeMachineOrderValidator {

	/**
	 * return null if enough money is given to buy the drink
	 * else it return a message with missing money
	 * @param drink
	 * @param givenMoney
	 * @return
	 */
	String checkIfEnoughMoney(Drink drink, float givenMoney);
}
