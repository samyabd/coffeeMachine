package arolla.interview.coffee_machine.bean;

import java.util.ArrayList;
import java.util.List;

import arolla.interview.coffee_machine.interfaces.ICoffeeMachineOrderValidator;
import arolla.interview.coffee_machine.interfaces.ICoffeeMachineTranslater;
import arolla.interview.coffee_machine.utility.Factory;

/**
 * The class that manages the application
 * 
 * @author samya
 *
 */
public class CoffeeMachineOrderManager {

	private ICoffeeMachineOrderValidator validator;
	private ICoffeeMachineTranslater translater;

	public CoffeeMachineOrderManager() {
		validator = Factory.createCoffeeMachineOrderValidator();
		translater = Factory.createCoffeeMachineTranslater();
	}

	/**
	 * return the instructions for the DRINK MAKER according to the received customer order
	 * @param customerOrder
	 * @return
	 */
	public List<String> consumeCustomerOrderIntoInstruction(CustomerOrder customerOrder) {
		List<String> retour = new ArrayList<String>();
		if (customerOrder != null) {
			String retourValidator = validator.checkIfEnoughMoney(customerOrder.getDrink(),
					customerOrder.getGivenMoney());
			if (retourValidator != null) {
				retour.add(retourValidator);
			} else {
				retour.add(translater.translateOrderIntoInstruction(customerOrder));

			}
		}

		return retour;
	}

}
