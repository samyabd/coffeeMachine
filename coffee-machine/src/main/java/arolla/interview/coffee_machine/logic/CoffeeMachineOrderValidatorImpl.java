package arolla.interview.coffee_machine.logic;

import arolla.interview.coffee_machine.drinks.Drink;
import arolla.interview.coffee_machine.utility.Constantes;

/**
 * The class that operate the controles on the order
 * @author samya
 *
 */
public class CoffeeMachineOrderValidatorImpl implements ICoffeeMachineOrderValidator{

	/**
	 * If the controle passes, the function return null
	 * @param drink
	 * @param givenMoney
	 * @return
	 */
	public String checkIfEnoughMoney(Drink drink, float givenMoney)
	{
		String retour = null;
		if(drink.getPrice()>givenMoney)
		{
			Float moneyMissing = drink.getPrice()-givenMoney;
			retour = Constantes.ERROR_MESSAGE_MISSING_MONEY.replace(Constantes.MONEY
					, moneyMissing.toString());
		}
		
		return retour;
	}

}
