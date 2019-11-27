package arolla.interview.coffee_machine;

import arolla.interview.coffee_machine.beans.TranslaterEntry;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.logic.InstructionTranslater;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InstructionTranslaterTest extends TestCase{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InstructionTranslaterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InstructionTranslaterTest.class );
    }
    
    public static void testTranslateOrderIntoInstruction()
    {
    	InstructionTranslater translater =  new InstructionTranslater();
    	
    	// test 1
    	TranslaterEntry entry = new TranslaterEntry(DrinkEnum.TEA.getDrinkCode(),1);
    	String instruction = translater.translateOrderIntoInstruction(entry);
    	assertTrue(instruction!=null && !instruction.isEmpty());
    	assertTrue(instruction.equals("T:1:0"));
    	
    	// test 2
    	entry = new TranslaterEntry(DrinkEnum.CHOCOLATE.getDrinkCode(),0);
    	instruction = translater.translateOrderIntoInstruction(entry);
    	assertTrue(instruction!=null && !instruction.isEmpty());
    	assertTrue(instruction.equals("H::"));
    	
    	// test 3
    	entry = new TranslaterEntry(DrinkEnum.COFFEE.getDrinkCode(),2);
    	instruction = translater.translateOrderIntoInstruction(entry);
    	assertTrue(instruction!=null && !instruction.isEmpty());
    	assertTrue(instruction.equals("C:2:0"));
    	
    	// test 4
    	instruction = translater.translateOrderIntoInstruction(null);
    	assertTrue(instruction==null);
    	

    }
    
    public static void testTranslateMessageIntoInstruction()
    {
    	InstructionTranslater translater =  new InstructionTranslater();
    	
    	String message = translater.translateMessageIntoInstruction("message-content");
    	assertTrue(message.equals("M:message-content"));
    }
}
