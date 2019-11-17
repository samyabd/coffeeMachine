package arolla.interview.coffee_machine.enums;

public enum DrinkEnum {

	TEA('T'),
	COFFEE('C'),
	CHOCOLATE('H');
	
	private final char drinkCode;
	 
    private DrinkEnum(char drinkCode) {
        this.drinkCode = drinkCode;
    }

	public char getDrinkCode() {
		return drinkCode;
	}
	
    
}
