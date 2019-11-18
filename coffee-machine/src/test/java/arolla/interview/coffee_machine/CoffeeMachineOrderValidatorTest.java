package arolla.interview.coffee_machine;

import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.interfaces.ICoffeeMachineOrderValidator;
import arolla.interview.coffee_machine.utility.Factory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CoffeeMachineOrderValidatorTest extends TestCase{

	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CoffeeMachineOrderValidatorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CoffeeMachineOrderValidatorTest.class );
    }
    
    public void testCoffeeMachineOrderValidator()
    {
    	ICoffeeMachineOrderValidator coffeeMachineOrderValidator= Factory.createCoffeeMachineOrderValidator();
    	
    	String retour1 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE)
    			, 0f);
    	assertEquals(retour1, "0.5e is missing");
    	
    	String retour2 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE)
    			, 0.1f);
    	assertEquals(retour2, "0.4e is missing");
    	
    	String retour3 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE)
    			, 0.5f);
    	assertEquals(retour3,null);
    	
    	String retour4 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE)
    			, 1f);
    	assertEquals(retour4,null);
    }
    
}
