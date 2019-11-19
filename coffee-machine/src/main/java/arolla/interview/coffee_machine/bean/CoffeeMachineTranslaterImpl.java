package arolla.interview.coffee_machine.bean;


import arolla.interview.coffee_machine.interfaces.ICoffeeMachineTranslater;
import arolla.interview.coffee_machine.utility.Constantes;

/**
 * 
 * @author samya
 * 
 * The class that translates orders from customers of the coffee machine
 *  to the drink maker.
 *
 */
public class CoffeeMachineTranslaterImpl implements ICoffeeMachineTranslater{
	
	public CoffeeMachineTranslaterImpl() {};
	
	/**
	 * Translates an order to an instruction 
	 * 
	 * @param order
	 * @return
	 */
	public String translateOrderIntoInstruction(CustomerOrder order)
	{
		String retour = null;
		
		if(order!=null)
		{
			retour = getDrinkInstruction(order);

			
		}

		return retour;
	}
	
	public String translateMessageIntoInstruction(String message)
	{
		String retour = null;
		
		if(message!=null)
		{
			retour = this.getMessageInstruction(message);
			
		}

		return retour;
	}
	
	/**
	 * get the instruction line for the drink order
	 * @param order
	 * @return
	 */
	private String getDrinkInstruction(CustomerOrder order)
	{
		StringBuilder drinkOrder = new StringBuilder();
		if(order.getDrink()!=null)
		{
			drinkOrder.append(order.getDrink().getDrinkCharCode());
			if(order.getDrink().isBoExtraHot())
			{
				drinkOrder.append('h');
			}
			drinkOrder.append(Constantes.DRINK_MAKER_PROTOCOLE_SEPARATOR);
			if(order.getDrink().getNbSugar()!=null)
			{
				drinkOrder.append(order.getDrink().getNbSugar());
				drinkOrder.append(Constantes.DRINK_MAKER_PROTOCOLE_SEPARATOR);
				drinkOrder.append(Constantes.ZERO);
			}
			else
			{
				drinkOrder.append(Constantes.DRINK_MAKER_PROTOCOLE_SEPARATOR);
			}
			
		}
		return drinkOrder.toString();
	}
	
	/**
	 * get the instruction line to forward a message
	 * @param orderMessage
	 * @return
	 */
	private String getMessageInstruction(String orderMessage)
	{
		StringBuilder messageInstruction = new StringBuilder();
		if(orderMessage!=null && !orderMessage.isEmpty())
		{
			messageInstruction.append(Constantes.DRINK_MAKER_PROTOCOLE_MESSAGE_CODE);
			messageInstruction.append(Constantes.DRINK_MAKER_PROTOCOLE_SEPARATOR);
			messageInstruction.append(orderMessage);
		}
		
		return messageInstruction.toString();
	}

}
