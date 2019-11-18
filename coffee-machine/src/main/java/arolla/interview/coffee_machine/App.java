package arolla.interview.coffee_machine;


import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import arolla.interview.coffee_machine.bean.CoffeeMachineOrderManager;
import arolla.interview.coffee_machine.bean.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;

/**
 * Example
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// example
    	CoffeeMachineOrderManager manager = new CoffeeMachineOrderManager();
    	CustomerOrder order = new CustomerOrder(DrinkEnum.TEA,0.4f,2);
    	List<String> listInstructions = manager.consumeCustomerOrderIntoInstruction(order);
    	
    	if(!CollectionUtils.isEmpty(listInstructions))
    	{
    		for(String instruction: listInstructions)
    		{
    			System.out.println(instruction);
    		}
    		
    	}
    	
    	
    }
}
