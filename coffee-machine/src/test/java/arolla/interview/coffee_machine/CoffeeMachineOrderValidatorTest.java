package arolla.interview.coffee_machine;

import arolla.interview.coffee_machine.bean.CustomerOrder;
import arolla.interview.coffee_machine.enums.DrinkEnum;
import arolla.interview.coffee_machine.logic.ICoffeeMachineOrderValidator;
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
    	
    	String retour1 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE,null)
    			, 0f);
    	assertEquals(retour1, "0.5e is missing");
    	
    	String retour2 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE,null)
    			, 0.1f);
    	assertEquals(retour2, "0.4e is missing");
    	
    	String retour3 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE,null)
    			, 0.5f);
    	assertEquals(retour3,null);
    	
    	String retour4 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.CHOCOLATE,null)
    			, 1f);
    	assertEquals(retour4,null);
    	
    	String retour5 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.ORANGE_JUICE,null)
    			, 1f);
    	assertEquals(retour5,null);
    	
    	String retour6 = coffeeMachineOrderValidator.checkIfEnoughMoney(Factory.createDrink(DrinkEnum.ORANGE_JUICE,null)
    			, 0.3f);
    	assertEquals(retour6,"0.3e is missing");

    }
    
}
