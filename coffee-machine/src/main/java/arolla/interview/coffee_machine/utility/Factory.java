package arolla.interview.coffee_machine.utility;

import arolla.interview.coffee_machine.bean.CoffeeMachineOrderValidatorImpl;
import arolla.interview.coffee_machine.bean.CoffeeMachineTranslaterImpl;
import arolla.interview.coffee_machine.drinks.Chocolate;
import arolla.interview.coffee_machine.drinks.Coffee;
import arolla.interview.coffee_machine.drinks.Drink;
import arolla.interview.coffee_machine.drinks.Tea;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.interfaces.ICoffeeMachineOrderValidator;
import arolla.interview.coffee_machine.interfaces.ICoffeeMachineTranslater;

public class Factory {

	public static Drink createDrink(DrinkEnum drinkEnum, Integer nbSugar)
	{
		Drink drink = null;
		if(drinkEnum!=null)
		{
			switch(drinkEnum)
			{
			case CHOCOLATE:
				drink = new Chocolate(nbSugar);
				break;
			case TEA:
				drink = new Tea(nbSugar);
				break;
			case COFFEE:
				drink = new Coffee(nbSugar);
				break;
			default: break;
			}
			
		}
		return drink;
	}
	
	public static ICoffeeMachineOrderValidator createCoffeeMachineOrderValidator()
	{
		return new CoffeeMachineOrderValidatorImpl();
	}
	public static ICoffeeMachineTranslater createCoffeeMachineTranslater()
	{
		return new CoffeeMachineTranslaterImpl();
	}
}
