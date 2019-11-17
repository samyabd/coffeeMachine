package arolla.interview.coffee_machine;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import arolla.interview.coffee_machine.core.CoffeeMachineTranslater;
import arolla.interview.coffee_machine.core.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CoffeeMachineTranslater translater =  new CoffeeMachineTranslater();
    	CustomerOrder order = new CustomerOrder(DrinkEnum.CHOCOLATE, null, null);
    	List<String> listInstructions = translater.translateOrderIntoInstruction(order);
    	if(!CollectionUtils.isEmpty(listInstructions))
    	{
    		for(String line: listInstructions)
    		{
    			System.out.println( line );
    		}
    	}
    	
    	
    }
}
