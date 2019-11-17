package arolla.interview.coffee_machine;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import arolla.interview.coffee_machine.core.CoffeeMachineTranslater;
import arolla.interview.coffee_machine.core.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Tests the instructions
     */
    public void testCoffeeMachineTranslater()
    {

    	CoffeeMachineTranslater translater =  new CoffeeMachineTranslater();
    	
    	// test 1
    	CustomerOrder order= new CustomerOrder(DrinkEnum.TEA, Short.valueOf("1"), null);
    	List<String> listInstructions = translater.translateOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("T:1:0"));
    	
    	// test 2
    	order = new CustomerOrder(DrinkEnum.CHOCOLATE, null, null);
    	listInstructions = translater.translateOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("H::"));
    	
    	// test 3
    	order = new CustomerOrder(DrinkEnum.COFFEE, Short.valueOf("2"), null);
    	listInstructions = translater.translateOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("C:2:0"));
    	
    	// test 4
    	order = new CustomerOrder(null, null, "message-content");
    	listInstructions = translater.translateOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==1);
    	assertTrue(listInstructions.get(0).equals("M:message-content"));
    	
    	// test 5
    	order = new CustomerOrder(DrinkEnum.COFFEE, null, "message-content");
    	listInstructions = translater.translateOrderIntoInstruction(order);
    	assertTrue(!CollectionUtils.isEmpty(listInstructions));
    	assertTrue(listInstructions.size()==2);
    	assertTrue(listInstructions.get(0).equals("C::"));
    	assertTrue(listInstructions.get(1).equals("M:message-content"));
    	
    	// test 5
    	order = new CustomerOrder(null, null, null);
    	listInstructions = translater.translateOrderIntoInstruction(order);
    	assertTrue(CollectionUtils.isEmpty(listInstructions));

    }
}
