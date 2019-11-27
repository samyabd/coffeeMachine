package arolla.interview.coffee_machine;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import arolla.interview.coffee_machine.beans.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.logic.InstructionTranslater;
import arolla.interview.coffee_machine.logic.TaskOrchestrator;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Exemple
    	
    	TaskOrchestrator taskOrchestrator= new TaskOrchestrator();
    	CustomerOrder order= new CustomerOrder(DrinkEnum.TEA, 1);
    	String retour = taskOrchestrator.consumeCustomerOrderIntoInstruction(order);
    	
    }
}
