package arolla.interview.coffee_machine.services;

public class DrinkRunningOutService{
	
	IBeverageQuantity beverageQuantity;
	
	IEmailNotifier emailNotifier;
	
	public DrinkRunningOutService(IBeverageQuantity beverageQuantity,IEmailNotifier emailNotifier )
	{
		this.beverageQuantity = beverageQuantity;
		this.emailNotifier = emailNotifier;
	}
	
	public boolean controleDrinkRunnedOut(String drink)
	{
		
		boolean retour = beverageQuantity.isEmpty(drink);
		
		if(retour)
		{
			emailNotifier.notifyMissingDrink(drink);
		}
		
		return retour;
	}

}
