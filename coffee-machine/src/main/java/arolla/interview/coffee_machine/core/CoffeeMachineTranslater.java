package arolla.interview.coffee_machine.core;

import java.util.ArrayList;
import java.util.List;

import arolla.interview.coffee_machine.utility.Constantes;

/**
 * 
 * @author samya
 * 
 * The class that translates orders from customers of the coffee machine
 *  to the drink maker.
 *
 */
public class CoffeeMachineTranslater {
	
	public CoffeeMachineTranslater() {};
	
	/**
	 * Translates an order to an instruction 
	 * 
	 * @param order
	 * @return
	 */
	public List<String> translateOrderIntoInstruction(CustomerOrder order)
	{
		List<String> retour = new ArrayList();
		
		if(order!=null)
		{
			String drinkOrder = getDrinkInstruction(order);
			if(drinkOrder!=null && !drinkOrder.isEmpty())
			{
				retour.add(drinkOrder);
			}
			
			String messageInstruction = getMessageInstruction(order.getMessage());
			if(messageInstruction!=null && !messageInstruction.isEmpty())
			{
				retour.add(messageInstruction);
			}
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
			drinkOrder.append(order.getDrink().getDrinkCode());
			drinkOrder.append(Constantes.DRINK_MAKER_PROTOCOLE_SEPARATOR);
			if(order.getNbSugar()!=null)
			{
				drinkOrder.append(order.getNbSugar());
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
