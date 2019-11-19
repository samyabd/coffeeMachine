package arolla.interview.coffee_machine.services;

import arolla.interview.coffee_machine.drinks.Chocolate;
import arolla.interview.coffee_machine.drinks.Coffee;
import arolla.interview.coffee_machine.drinks.Drink;
import arolla.interview.coffee_machine.drinks.OrangeJuice;
import arolla.interview.coffee_machine.drinks.Tea;
import arolla.interview.coffee_machine.repository.ReportingRepositorySimulation;

public class ReportingServiceImpl implements IReportingService{

	private ReportingRepositorySimulation reportingRepository;
	
	public ReportingServiceImpl()
	{
		reportingRepository = new ReportingRepositorySimulation();
		
	}
	
	public void updateRepository(Drink drinkSold)
	{
		if(drinkSold instanceof Coffee)
		{
			this.reportingRepository.setCoffeeSold(this.reportingRepository.getCoffeeSold()+1);
		}
		else if(drinkSold instanceof Tea)
		{
			this.reportingRepository.setTeaSold(this.reportingRepository.getTeaSold()+1);
		}
		else if(drinkSold instanceof Chocolate)
		{
			this.reportingRepository.setChocolateSold(this.reportingRepository.getChocolateSold()+1);
		}
		else if(drinkSold instanceof OrangeJuice)
		{
			this.reportingRepository.setOrangeJuiceSold(this.reportingRepository.getOrangeJuiceSold()+1);
		}
		
		this.reportingRepository.setTotalSold(this.reportingRepository.getTotalSold()+drinkSold.getPrice());
		
	}
	
	public String printReporting()
	{
		return this.reportingRepository.toString();
	}
}
