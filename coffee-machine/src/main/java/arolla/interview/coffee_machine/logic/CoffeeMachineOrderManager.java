package arolla.interview.coffee_machine.logic;

import java.util.ArrayList;
import java.util.List;

import arolla.interview.coffee_machine.bean.CustomerOrder;
import arolla.interview.coffee_machine.services.IReportingService;
import arolla.interview.coffee_machine.services.ReportingServiceImpl;
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
	private IReportingService reportingManager;

	public CoffeeMachineOrderManager() {
		validator = Factory.createCoffeeMachineOrderValidator();
		translater = Factory.createCoffeeMachineTranslater();
		reportingManager = new ReportingServiceImpl();
	}

	/**
	 * return the instructions for the DRINK MAKER according to the received customer order
	 * @param customerOrder
	 * @return
	 */
	public List<String> consumeCustomerOrderIntoInstruction(CustomerOrder customerOrder) {
		List<String> retour = new ArrayList<String>();
		if (customerOrder != null && customerOrder.getDrink()!=null) {
			String retourValidator = validator.checkIfEnoughMoney(customerOrder.getDrink(),
					customerOrder.getGivenMoney());
			if (retourValidator != null) {
				retour.add(retourValidator);
			} else {
				// TODO controle with DrinkRunningOutService that the drink is still available, if not we skip the 2 lines that follow (cant do that because i dont have the coffee machine implementation :) )
				retour.add(translater.translateOrderIntoInstruction(customerOrder));
				this.reportingManager.updateRepository(customerOrder.getDrink());

			}
		}

		return retour;
	}

	public String generateReporting()
	{
		return this.reportingManager.printReporting();
	}
}
