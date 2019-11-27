package arolla.interview.coffee_machine.logic;

import arolla.interview.coffee_machine.beans.CustomerOrder;
import arolla.interview.coffee_machine.beans.TranslaterEntry;

public class CustomerOrderToTranslaterEntryConverter {

	public TranslaterEntry convertCustomerOrderToEntry(CustomerOrder order)
	{
		return new TranslaterEntry(order.getDrink().getDrinkCode(), order.getNbSugar());
	}
}
