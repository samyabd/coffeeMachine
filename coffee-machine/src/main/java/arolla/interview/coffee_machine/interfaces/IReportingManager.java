package arolla.interview.coffee_machine.interfaces;

import arolla.interview.coffee_machine.drinks.Drink;

public interface IReportingManager {

	 void updateRepository(Drink drinkSold);
	 String printReporting();
}
