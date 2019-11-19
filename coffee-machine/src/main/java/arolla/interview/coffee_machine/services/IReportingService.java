package arolla.interview.coffee_machine.services;

import arolla.interview.coffee_machine.drinks.Drink;

public interface IReportingService {

	 void updateRepository(Drink drinkSold);
	 String printReporting();
}
