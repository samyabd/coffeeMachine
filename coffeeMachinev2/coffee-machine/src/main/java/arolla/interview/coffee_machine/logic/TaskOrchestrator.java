package arolla.interview.coffee_machine.logic;

import arolla.interview.coffee_machine.beans.CustomerOrder;
import arolla.interview.coffee_machine.beans.TranslaterEntry;

/**
 * The class that orchestrates the process to get the instructions from the customer orders. 
 * @author samya
 *
 */
public class TaskOrchestrator {

	private CustomerOrderToTranslaterEntryConverter customerOrderToTranslaterEntryConverter;
	private InstructionTranslater instructionTranslater;
	
	public TaskOrchestrator()
	{
		this.customerOrderToTranslaterEntryConverter = new CustomerOrderToTranslaterEntryConverter();
		this.instructionTranslater = new InstructionTranslater();
	}
	
	/**
	 * returns the instructions for the DRINK MAKER according to the received customer order
	 * @param customerOrder
	 * @return
	 */
	public String consumeCustomerOrderIntoInstruction(CustomerOrder order)
	{
		String retour = null;
		
		if(order!=null)
		{
			TranslaterEntry translaterEntry = customerOrderToTranslaterEntryConverter.convertCustomerOrderToEntry(order);
			retour = instructionTranslater.translateOrderIntoInstruction(translaterEntry);
		}
		
				
		return retour;
	}
	
	/**
	 * forwards a translated message to the DRINK MAKER into an instruction
	 * @param message
	 * @return
	 */
	public String forwardMessageToDrinkMaker(String message)
	{
		return this.instructionTranslater.translateMessageIntoInstruction(message);
	}
}
