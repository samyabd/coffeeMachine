package arolla.interview.coffee_machine;


import arolla.interview.coffee_machine.bean.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.interfaces.ICoffeeMachineTranslater;
import arolla.interview.coffee_machine.utility.Factory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CoffeeMachineTranslaterTest extends TestCase{

	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CoffeeMachineTranslaterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CoffeeMachineTranslaterTest.class );
    }
    
	/**
     * Tests the translation of instructions (refactoré depuis la 1ere itération)
     */
    public void testCoffeeMachineTranslater()
    {

    	ICoffeeMachineTranslater translater =  Factory.createCoffeeMachineTranslater();
    	
    	// test 1
    	CustomerOrder order= new CustomerOrder(DrinkEnum.TEA, Short.valueOf("1"), 0.4f);
    	String instructionLine = translater.translateOrderIntoInstruction(order);
    	assertTrue(instructionLine !=null && !instructionLine.isEmpty());
    	assertTrue(instructionLine.equals("T:1:0"));
    	
    	// test 2
    	order = new CustomerOrder(DrinkEnum.CHOCOLATE, null, 0.5f);
    	instructionLine = translater.translateOrderIntoInstruction(order);
    	assertTrue(instructionLine !=null && !instructionLine.isEmpty());
    	assertTrue(instructionLine.equals("H::"));
    	
    	// test 3
    	order = new CustomerOrder(DrinkEnum.COFFEE, Short.valueOf("2"), 0.6f);
    	instructionLine = translater.translateOrderIntoInstruction(order);
    	assertTrue(instructionLine !=null && !instructionLine.isEmpty());
    	assertTrue(instructionLine.equals("C:2:0"));
    	
    	// test 4
    	String messageToForward = "message-content";
    	instructionLine = translater.translateMessageIntoInstruction(messageToForward);
    	assertTrue(instructionLine !=null && !instructionLine.isEmpty());
    	assertTrue(instructionLine.equals("M:message-content"));

    }
}
