package arolla.interview.coffee_machine.beans;

public class TranslaterEntry {

	public TranslaterEntry(char drinkCharCode, int nbSugar) {
		this.drinkCharCode = drinkCharCode;
		this.nbSugar = nbSugar;
	};
	
	private char drinkCharCode;
	private int nbSugar;
	
	public char getDrinkCharCode() {
		return drinkCharCode;
	}
	public int getNbSugar() {
		return nbSugar;
	}
	
	

	
}
