package arolla.interview.coffee_machine.drinks;

public abstract class Drink {

	private char drinkCharCode;
	private float price;
	protected Integer nbSugar;
	
	public Drink(char drinkCharCode, float price, Integer nbSugar) {
		super();
		this.drinkCharCode = drinkCharCode;
		this.price = price;
		this.nbSugar = nbSugar;
	}
	
	public char getDrinkCharCode() {
		return drinkCharCode;
	}
	public float getPrice() {
		return price;
	}
	
	/**
	 * return the amount of money which is missing to buy the drink according 
	 * to the given money
	 * 
	 * @param givenMoney
	 * @return
	 */
	public float checkAmountOfMoneyMissing(float givenMoney)
	{
		return (givenMoney - price);
	}

	public Integer getNbSugar() {
		return nbSugar;
	}

	
	
	
}
