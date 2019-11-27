package arolla.interview.coffee_machine;

import arolla.interview.coffee_machine.beans.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.logic.TaskOrchestrator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TaskOrchestratorTest extends TestCase{

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TaskOrchestratorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TaskOrchestratorTest.class );
    }
    
    public static void testTranslateOrderIntoInstruction()
    {
    	TaskOrchestrator taskOrchestrator = new TaskOrchestrator();
    	
    	// test 1
    	CustomerOrder order= new CustomerOrder(DrinkEnum.TEA, 1);
    	String instruction = taskOrchestrator.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(instruction!=null && !instruction.isEmpty());
    	assertTrue(instruction.equals("T:1:0"));
    	
    	// test 2
    	order = new CustomerOrder(DrinkEnum.CHOCOLATE, 0);
    	instruction = taskOrchestrator.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(instruction!=null && !instruction.isEmpty());
    	assertTrue(instruction.equals("H::"));
    	
    	// test 3
    	order = new CustomerOrder(DrinkEnum.COFFEE,2);
    	instruction = taskOrchestrator.consumeCustomerOrderIntoInstruction(order);
    	assertTrue(instruction!=null && !instruction.isEmpty());
    	assertTrue(instruction.equals("C:2:0"));
    	
    	// test 4
    	instruction = taskOrchestrator.consumeCustomerOrderIntoInstruction(null);
    	assertTrue(instruction==null);
    }
    
    public static void forwardMessageToDrinkMaker()
    {
    	TaskOrchestrator taskOrchestrator = new TaskOrchestrator();
    	
    	String message = taskOrchestrator.forwardMessageToDrinkMaker("message-content");
    	assertTrue(message!=null && !message.isEmpty());
    	assertTrue(message.equals("M:message-content"));
    }
}
