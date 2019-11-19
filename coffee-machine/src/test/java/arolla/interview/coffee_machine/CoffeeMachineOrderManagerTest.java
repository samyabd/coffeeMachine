package arolla.interview.coffee_machine;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import arolla.interview.coffee_machine.bean.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.logic.CoffeeMachineOrderManager;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CoffeeMachineOrderManagerTest extends TestCase{

	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CoffeeMachineOrderManagerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CoffeeMachineOrderManagerTest.class );
    }
    
    /**
     * Test the logic of the CoffeeMachineManager (2eme itération)
     */
    public void testCoffeeMachineManager()
    {
    	CoffeeMachineOrderManager coffeeMachineOrderManager = new CoffeeMachineOrderManager();
    	CustomerOrder order= new CustomerOrder(DrinkEnum.TEA, 0.25f,1);
    	List<String>  listInstructions = coffeeMachineOrderManager.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("0.15e is missing"));
    	
    	order = new CustomerOrder(DrinkEnum.COFFEE, 0.6f,2);
    	listInstructions = coffeeMachineOrderManager.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("C:2:0"));
    	
    	listInstructions = coffeeMachineOrderManager.consumeCustomerOrderIntoInstruction(null);
    	assertTrue(CollectionUtils.isEmpty(listInstructions));
    	
    	order = new CustomerOrder(DrinkEnum.CHOCOLATE, 0f,2);
    	listInstructions = coffeeMachineOrderManager.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("0.5e is missing"));
    	
    	order = new CustomerOrder(DrinkEnum.CHOCOLATE, 29f,2);
    	listInstructions = coffeeMachineOrderManager.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("H:2:0"));
    	
    	String reporting = coffeeMachineOrderManager.generateReporting();
    	assertTrue(reporting !=null && !reporting.isEmpty());
    	StringBuilder expectedReporting = new StringBuilder();
    	expectedReporting.append("Coffee: 1 sold, Chocolat 1 sold, Tea 0 sold, Orange Juice 0 sold, total sold: 1.1e");
    	assertTrue(reporting.equals(expectedReporting.toString()));
    	
    }

}
