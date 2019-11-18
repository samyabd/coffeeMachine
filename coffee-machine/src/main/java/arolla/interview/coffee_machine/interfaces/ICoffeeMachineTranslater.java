package arolla.interview.coffee_machine.interfaces;

import arolla.interview.coffee_machine.bean.CustomerOrder;

public interface ICoffeeMachineTranslater {
	/**
	 * translates an order into a drink maker instruction line
	 * @param order
	 * @return
	 */
	 String translateOrderIntoInstruction(CustomerOrder order);
	 
	 /**
	  * translates a message into a drink maker instruction line
	  * @param message
	  * @return
	  */
	 String translateMessageIntoInstruction(String message);
}
