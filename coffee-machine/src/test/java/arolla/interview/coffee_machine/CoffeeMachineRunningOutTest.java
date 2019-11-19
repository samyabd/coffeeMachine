package arolla.interview.coffee_machine;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.BDDMockito.*;
import arolla.interview.coffee_machine.services.DrinkRunningOutService;
import arolla.interview.coffee_machine.services.IBeverageQuantity;
import arolla.interview.coffee_machine.services.IEmailNotifier;



@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineRunningOutTest{



    
 
    @Test
    public void testRunningOutFunctionnality()
    {
    	IBeverageQuantity beverageUserQuantity = Mockito.mock(IBeverageQuantity.class);
    	IEmailNotifier emailNotifier = Mockito.mock(IEmailNotifier.class);
    	DrinkRunningOutService runningOutService = new DrinkRunningOutService(beverageUserQuantity, emailNotifier);
    	String drink = "drink";
    	given(beverageUserQuantity.isEmpty(drink))
    	  .willReturn(true);
    	runningOutService.controleDrinkRunnedOut(drink);
    	verify(emailNotifier, times(1)).notifyMissingDrink(drink);
    	
    	given(beverageUserQuantity.isEmpty(drink))
    	.willReturn(false);
    	runningOutService.controleDrinkRunnedOut(drink);
    	verify(emailNotifier, times(1)).notifyMissingDrink(drink);

    }
}
