package arolla.interview.coffee_machine.utility;

import arolla.interview.coffee_machine.drinks.Chocolate;
import arolla.interview.coffee_machine.drinks.Coffee;
import arolla.interview.coffee_machine.drinks.Drink;
import arolla.interview.coffee_machine.drinks.OrangeJuice;
import arolla.interview.coffee_machine.drinks.Tea;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.logic.CoffeeMachineOrderValidatorImpl;
import arolla.interview.coffee_machine.logic.CoffeeMachineTranslaterImpl;
import arolla.interview.coffee_machine.logic.ICoffeeMachineOrderValidator;
import arolla.interview.coffee_machine.logic.ICoffeeMachineTranslater;
import arolla.interview.coffee_machine.services.IReportingService;
import arolla.interview.coffee_machine.services.ReportingServiceImpl;

public class Factory {
	
	public static Drink createDrink(DrinkEnum drinkEnum, Integer nbSugar)
	{
		return createDrink(drinkEnum,nbSugar, false);
	}
	public static Drink createDrink(DrinkEnum drinkEnum, Integer nbSugar, boolean boExtraHot)
	{
		Drink drink = null;
		if(drinkEnum!=null)
		{
			switch(drinkEnum)
			{
			case CHOCOLATE:
				drink = new Chocolate(nbSugar, boExtraHot);
				break;
			case TEA:
				drink = new Tea(nbSugar, boExtraHot);
				break;
			case COFFEE:
				drink = new Coffee(nbSugar, boExtraHot);
				break;
			case ORANGE_JUICE:
				drink = new OrangeJuice();
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
	
	public static IReportingService createReportingManager()
	{
		return new ReportingServiceImpl();
	}
	
}
